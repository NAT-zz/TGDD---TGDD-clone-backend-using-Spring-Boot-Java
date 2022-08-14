package hcmute.edu.tgdd.security.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hcmute.edu.tgdd.exception.handler.MyExceptionResonseHandler;
import hcmute.edu.tgdd.model.DataResponse;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	private final AuthenticationManager authenticationManager;
	
	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("phone");
		String password = request.getParameter("password");
		Authentication authenticate = null;
		try
		{
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
			authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		}
		catch (Exception e) {
			response.setHeader("Error", e.getMessage());
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);					
	        response.setContentType("application/json");
			try {
				new ObjectMapper().writeValue(response.getOutputStream(),  new DataResponse("403", "Bad credentials",200));
			} catch (StreamWriteException e1) {
				e1.printStackTrace();
			} catch (DatabindException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return authenticate;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authentication) throws IOException, ServletException {
		User user = (User) authentication.getPrincipal();
		Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
		String accessToken = JWT.create()
				// something unique
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
				.withIssuer(request.getRequestURL().toString())
				.withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.sign(algorithm);
		
		String refreshToken = JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
				.withIssuer(request.getRequestURL().toString())
				.sign(algorithm);
				
		Map<String, String> tokens = new HashMap<>();
		tokens.put("access_token", accessToken);
		tokens.put("refresh_token", refreshToken);
		
		MyExceptionResonseHandler.exceptionResponseHandler(response, new DataResponse(tokens), null);
	}		

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setHeader("Authentication", "Failed");
		MyExceptionResonseHandler.exceptionResponseHandler(response, new DataResponse(failed), failed);
	}
	
}
