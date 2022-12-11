package dev.patricksilva.photoappapiusers.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/**").permitAll()
                .and().build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .antMatchers("/users/**");
    }

    /*
     * @Bean
     * public WebSecurityCustomizer webSecurityCustomizer(HttpSecurity http) throws
     * Exception {
     * 
     * http.csrf().disable();
     * http.authorizeRequests().antMatchers("/users/**").permitAll();
     * 
     * return (web) -> web.ignoring().antMatchers("/users/**");
     * }
     */

    /*
     * @Bean
     * public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     * return http
     * .csrf().disable()
     * .authorizeRequests()
     * .antMatchers("/users/**").permitAll()
     * .anyRequest().authenticated()
     * .and().httpBasic()
     * .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.
     * STATELESS)
     * .and().build();
     * }
     * 
     * @Bean
     * public WebSecurityCustomizer webSecurityCustomizer() {
     * return (web) -> web.ignoring()
     * .antMatchers("/users/**");
     * }
     */
}