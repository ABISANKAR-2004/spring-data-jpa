/*
 * package com.ibm.security;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.Customizer; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import org.springframework.security.core.userdetails.User;
 * import org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.provisioning.InMemoryUserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class StudentSecurityConfig {
 * 
 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
 * throws Exception { http.csrf(csrf -> csrf.disable()) .authorizeHttpRequests(
 * auth->
 * auth.requestMatchers("/api/student/greeting").permitAll().anyRequest().
 * authenticated()) .httpBasic(Customizer.withDefaults());
 * 
 * return http.build(); }
 * 
 * @Bean public UserDetailsService userDetailsService() {
 * 
 * UserDetails user =
 * User.withUsername("abi").password(passwpEncoder().encode("123root")).roles(
 * "USER").build(); UserDetails admin =
 * User.withUsername("admin").password(passwpEncoder().encode("root@123")).roles
 * ("ADMIN").build();
 * 
 * return new InMemoryUserDetailsManager(user,admin); }
 * 
 * @Bean public PasswordEncoder passwpEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * }
 */