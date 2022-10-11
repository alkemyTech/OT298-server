package com.alkemy.ong.security.config;

import com.alkemy.ong.exception.CustomAccessDeniedHandler;
import com.alkemy.ong.exception.CustomAuthenticationEntryPoint;
import com.alkemy.ong.security.filter.JwtRequestFilter;
import com.alkemy.ong.security.service.impl.UserServiceImpl;

import static com.alkemy.ong.util.Constants.ROLE_USER;
import static com.alkemy.ong.util.Constants.ALL_ROLES;
import static com.alkemy.ong.util.Constants.Endpoints.*;
import static com.alkemy.ong.util.Constants.ROLE_ADMIN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.Filter;
import org.springframework.http.HttpMethod;


@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceImpl userDetailsCustomService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers(API_UI_ANTMATCHER, API_DESCRIPTION_ANTMATCHER).permitAll()
                .and().authorizeRequests()
                .antMatchers("/auth/*").permitAll()
                .antMatchers(HttpMethod.GET, USER).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.PATCH, USER_UPDATE).hasAnyAuthority(ALL_ROLES)
                .antMatchers(HttpMethod.DELETE, USER_UPDATE).hasAnyAuthority(ROLE_USER)
                .antMatchers(HttpMethod.PUT, "/news/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.DELETE, "/news/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/news/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.DELETE, "/categories/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.PUT, "/categories/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/categories/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, SLIDE).hasAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, SLIDE_UPDATE).hasAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.PUT, SLIDE_UPDATE).hasAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/organization/public").hasAnyAuthority(ALL_ROLES)
                .antMatchers(HttpMethod.PUT, "/testimonials/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/contacts").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.PATCH, "/organization/public/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.PATCH, "/organization/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST, "/activities").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST, "/categories").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.DELETE, "/testimonials/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, MEMBER).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/comments").hasAnyAuthority(ROLE_ADMIN)
                .anyRequest().authenticated()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(authenticationEntryPoint())
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        httpSecurity.addFilterBefore((Filter) jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsCustomService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new CustomAuthenticationEntryPoint();
    }
}