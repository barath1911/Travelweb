package com.example.Travelweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.Travelweb.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http){///securityfiletrchain has methods()//htttpsecurity than parameter//
		 http
        .csrf(csrf ->csrf.disable())
        .authorizeHttpRequests(authz -> authz
            .requestMatchers(
                "/signup",
                "/signin",
                "/css/**",
                "/js/**",
                "/images/**"	
            ).permitAll()
            .requestMatchers("/success").authenticated()//not permit this link//login finished then success page view//
            .anyRequest().authenticated()
        )
      
        .formLogin(form -> form
            .loginPage("/signin")
            .usernameParameter("email")
            .passwordParameter("password")
            .defaultSuccessUrl("/success", true)// 🔑 IMPORTANT
            .failureUrl("/signin?error=true")
            .permitAll()
            );
		return http.build();
	}
	

	/*@Bean
	*public UserDetailsService userDetailService() {
		*
		 * UserDetails user=User.withUsername("barath")
		 * .password(passwordEncoder.encode("user123")) .roles("USER") .build();
		 * 
		 * UserDetails admin=User.withUsername("shiva")
		 * .password(passwordEncoder.encode("admin123")) .roles("ADMIN") .build();
		 * 
		 * return new InMemoryUserDetailsManager(user,admin);
		 
		return new CustomUserDetailsService();
	}*/

	@Bean
	public DaoAuthenticationProvider authenticationProvider(
	        UserDetailsService userDetailsService,
	        PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder);
		return authProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
}
