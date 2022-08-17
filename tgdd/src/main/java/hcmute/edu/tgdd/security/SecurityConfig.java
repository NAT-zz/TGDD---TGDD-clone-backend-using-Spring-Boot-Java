package hcmute.edu.tgdd.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import hcmute.edu.tgdd.exception.handler.MyExceptionResonseHandler;
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
	AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
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

    //user
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/user/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/user/insert").hasAnyAuthority(Role.ROLE_ADMIN.toString(), Role.ROLE_CUSTOMER.toString());
    http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/user/**").hasAnyAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/user/**").hasAnyAuthority(Role.ROLE_ADMIN.toString());
    //product
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/Product/**").permitAll();
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/Product/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/Product/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/Product/**").hasAuthority(Role.ROLE_ADMIN.toString());
    //status
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/Status").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/Status/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/Status/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/Status/**").hasAuthority(Role.ROLE_ADMIN.toString());
    //nation
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/Nation/**").permitAll();
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/Nation/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/Nation/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/Nation/**").hasAuthority(Role.ROLE_ADMIN.toString());
    //kind
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/kind/**").permitAll();
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/kind/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/kind/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/kind/**").hasAuthority(Role.ROLE_ADMIN.toString());
    //company
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/Company/**").permitAll();
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/Company/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/Company/**").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/Company/**").hasAuthority(Role.ROLE_ADMIN.toString());
    //comment
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/Comment/**").permitAll();
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/Comment/**").hasAnyAuthority(Role.ROLE_ADMIN.toString(), Role.ROLE_CUSTOMER.toString());
    http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/Comment/**").hasAuthority(Role.ROLE_ADMIN.toString());
    //cart
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/CartDetail/export").hasAuthority(Role.ROLE_ADMIN.toString());
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/CartDetail", "/api/Cart").hasAnyAuthority(Role.ROLE_ADMIN.toString(), Role.ROLE_CUSTOMER.toString());
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/CartDetail/**", "/api/Cart").hasAnyAuthority(Role.ROLE_ADMIN.toString(), Role.ROLE_CUSTOMER.toString());
    http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/CartDetail/**", "/api/Cart").hasAnyAuthority(Role.ROLE_ADMIN.toString(), Role.ROLE_CUSTOMER.toString());
    http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/CartDetail/**", "/api/Cart").hasAnyAuthority(Role.ROLE_ADMIN.toString(), Role.ROLE_CUSTOMER.toString());

    http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
      @Override
      public void handle(HttpServletRequest request, HttpServletResponse response,
          AccessDeniedException accessDeniedException) throws IOException, ServletException {
        MyExceptionResonseHandler.exceptionResponseHandler(response, new DataResponse("403", "Access is denied", 200), null);
      }
    });

    http.authorizeRequests().anyRequest().authenticated();
    http.addFilter(customAuthenticationFilter);
    http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    return http.getOrBuild();
  }
}
