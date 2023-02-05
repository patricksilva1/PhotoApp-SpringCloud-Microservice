package dev.patricksilva.photoappapiusers.security;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.patricksilva.photoappapiusers.service.UsersService;
import dev.patricksilva.photoappapiusers.shared.UserDto;
import dev.patricksilva.photoappapiusers.ui.controller.model.LoginRequestModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

        private UsersService usersService;
        private Environment environment;

        public AuthenticationFilter(UsersService usersService, Environment environment,
                        AuthenticationManager authenticationManager) {
                this.usersService = usersService;
                this.environment = environment;
                super.setAuthenticationManager(authenticationManager);
        }

        @Override
        public Authentication attemptAuthentication(HttpServletRequest req,
                        HttpServletResponse res) throws AuthenticationException {
                try {

                        LoginRequestModel creds = new ObjectMapper()
                                        .readValue(req.getInputStream(), LoginRequestModel.class);

                        return getAuthenticationManager().authenticate(
                                        new UsernamePasswordAuthenticationToken(
                                                        creds.getEmail(),
                                                        creds.getPassword(),
                                                        new ArrayList<>()));

                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }

        @Override
        protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                        Authentication auth) throws IOException, ServletException {

                String userName = ((User) auth.getPrincipal()).getUsername();
                UserDto userDetails = usersService.getUserDetailsByEmail(userName);

                byte[] keyBytes = Decoders.BASE64.decode(environment.getProperty("token.secret"));

                Key key = Keys.hmacShaKeyFor(keyBytes);

                String token = Jwts.builder()
                                .setSubject(userDetails.getUserId())
                                .setExpiration(new Date(
                                                System.currentTimeMillis() + Long.parseLong(
                                                                environment.getProperty("token.expiration_time"))))
                                .signWith(key, SignatureAlgorithm.HS512)
                                .compact();

                res.addHeader("token", token);
                res.addHeader("userId", userDetails.getUserId());
        }
        /*
         * 
         * @Override
         * protected void successfulAuthentication(HttpServletRequest req,
         * HttpServletResponse res,
         * FilterChain chain,
         * Authentication auth) throws IOException, ServletException {
         * String userName = ((User) auth.getPrincipal()).getUsername();
         * UserDto userDetails = usersService.getUserDetailsByEmail(userName);
         * 
         * String token = Jwts.builder()
         * .setSubject(userDetails.getUserId())
         * .setExpiration(new Date(System.currentTimeMillis() +
         * Long.parseLong(environment.getProperty("token.expiration_time"))))
         * .signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret") )
         * .compact();
         * 
         * res.addHeader("token", token);
         * res.addHeader("userId", userDetails.getUserId());
         * }
         */
}
