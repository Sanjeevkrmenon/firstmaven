package com.mycompany.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests((authz) -> authz
            .requestMatchers("/login").permitAll() // Allow access to the login page
            .anyRequest().authenticated() // Require authentication for all other requests
      )
      .formLogin(form -> form
        .loginPage("/login") // Use a custom login page, you can create the UI yourself
        .defaultSuccessUrl("/", true) // Redirect to the root after successful login
        .permitAll()
      )
      .logout(logout -> logout.permitAll()); // Enable logout
      http.csrf().disable(); // disable csrf
    return http.build();
  }
@Bean
public UserDetailsService userDetailsService() {
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

  UserDetails user = User.withUsername("user")
      .password(encoder.encode("password")) // Store the password
      .roles("USER") // You can set roles here
      .build();

    return new InMemoryUserDetailsManager(user);
}
}