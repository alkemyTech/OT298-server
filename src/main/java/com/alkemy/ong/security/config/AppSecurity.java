package com.alkemy.ong.security.config;

import com.alkemy.ong.exception.CustomAccessDeniedHandler;
import com.alkemy.ong.exception.CustomAuthenticationEntryPoint;
import com.alkemy.ong.security.filter.JwtRequestFilter;
import com.alkemy.ong.security.service.impl.UserDetailsCustomServiceImpl;
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
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

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
                .antMatchers(DOCS).permitAll()
                .antMatchers(AUTH_ALL).permitAll()
                .antMatchers(HttpMethod.GET, USER).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.PATCH, USER_ID).hasAnyAuthority(ALL_ROLES)
                .antMatchers(HttpMethod.DELETE, USER_ID).hasAnyAuthority(ALL_ROLES)
                .antMatchers(HttpMethod.PUT, NEWS_ID).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.DELETE, NEWS_ID).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, NEWS_ID).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, NEWS_ALL).permitAll()
                .antMatchers(HttpMethod.DELETE, CATEGORY_ID).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.PUT, CATEGORY_ID).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, CATEGORY_ID).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, SLIDE).hasAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, SLIDE_ID).hasAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.PUT, SLIDE_ID).hasAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/organization/public").hasAnyAuthority(ALL_ROLES)
                .antMatchers(HttpMethod.PUT, "/testimonials/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/contacts").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.PATCH, "/organization/public/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.PATCH, "/organization/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST, "/activities").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST, CATEGORY).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.DELETE, "/testimonials/{id}").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, MEMBER).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/comments").hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/testimonials/page").hasAnyAuthority(ALL_ROLES)
                .antMatchers(HttpMethod.DELETE, MEMBER_ID).hasAnyAuthority(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET, "/news/{id}/comment").hasAnyAuthority(ALL_ROLES)
                .antMatchers(HttpMethod.PATCH, "/comments/{id}").hasAnyAuthority(ALL_ROLES)
                .anyRequest().authenticated()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(authenticationEntryPoint())
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore((Filter) jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsCustomServiceImpl()).passwordEncoder(passwordEncoder());
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
    
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsCustomServiceImpl();
    }
}
