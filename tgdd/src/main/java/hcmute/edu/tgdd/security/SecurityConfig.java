package hcmute.edu.tgdd.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.model.User.Role;
import hcmute.edu.tgdd.security.filter.CustomAuthenticationFilter;
import hcmute.edu.tgdd.security.filter.CustomAuthorizationFilter;

@Configuration @EnableWebSecurity 
public class SecurityConfig{
	private final UserDetailsService userDetailService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public SecurityConfig(UserDetailsService userDetailService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userDetailService = userDetailService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	@Bean
	AuthenticationConfiguration authenticationConfiguration() {
		return new AuthenticationConfiguration();
	}
	@Bean
	AuthenticationManager authenticationManager(
	        AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	}
	
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
    	// Configure AuthenticationManagerBuilder
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);

        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager(authenticationConfiguration()));
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/api/login/**", "/api/user/token/refresh/**").permitAll();
        
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/getAllUsers").hasAuthority(Role.ROLE_ADMIN.toString());
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/Product").hasAnyAuthority(Role.ROLE_ADMIN.toString(), Role.ROLE_CUSTOMER.toString());
        // http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/user/save/**").hasAuthority("ROLE_ADMIN");

        http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
			
			@Override
			public void handle(HttpServletRequest request, HttpServletResponse response,
					AccessDeniedException accessDeniedException) throws IOException, ServletException {
				response.setHeader("Error", accessDeniedException.getMessage());
		        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);					
		        response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(),  new DataResponse("403", "Access is denied",200));
			}
		});
        
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.getOrBuild();
    }
    class CustomAccessDecisionManager implements AccessDecisionManager{

		@Override
		public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
				throws AccessDeniedException, InsufficientAuthenticationException {
			if (!authentication.isAuthenticated())
				System.out.println("LAJSDKAJSDKASKDJ  LOLLLOL");
		}

		@Override
		public boolean supports(ConfigAttribute attribute) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean supports(Class<?> clazz) {
			// TODO Auto-generated method stub
			return false;
		}
    	
    }
}

