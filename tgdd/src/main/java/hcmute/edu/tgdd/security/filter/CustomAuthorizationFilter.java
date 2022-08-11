package hcmute.edu.tgdd.security.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.ObjectMapper;

import hcmute.edu.tgdd.model.DataResponse;

public class CustomAuthorizationFilter extends OncePerRequestFilter{
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(request.getServletPath().equals("/api/login") || request.getServletPath().equals("/api/user/token/refresh")) {
			filterChain.doFilter(request, response);
		}else {
			String authorizationHeader = request.getHeader("Authorization");
			if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
				try {
					String token = authorizationHeader.substring("Bearer ".length());
					Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
					
					JWTVerifier verifier = JWT.require(algorithm).build();
					DecodedJWT decodedJWT = verifier.verify(token);
					String username = decodedJWT.getSubject();
					String[] roles = decodedJWT.getClaim("roles").asArray(String.class); 
					
					Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
					for(int i=0;i<roles.length;i++)
						authorities.add(new SimpleGrantedAuthority(roles[i]));						

					UsernamePasswordAuthenticationToken authenticationToken = 
							new UsernamePasswordAuthenticationToken(username , null, authorities);
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					filterChain.doFilter(request, response);
				}
				catch (Exception e) {	
					response.setHeader("Error", e.getMessage());
			        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);					
			        response.setContentType("application/json");
					new ObjectMapper().writeValue(response.getOutputStream(),  new DataResponse("403", "Access is denied",200));
				}
			}
			else {
		        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);					
		        response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(),  new DataResponse("403", "Access is denied",200));
				filterChain.doFilter(request, response);
			}
		}
	}

}