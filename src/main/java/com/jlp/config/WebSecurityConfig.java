package com.jlp.config;

import com.jlp.config.security.AjaxAuthFailureHandler;
import com.jlp.config.security.AjaxAuthSuccessHandler;
import com.jlp.config.security.AjaxLogoutSuccessHandler;
import com.jlp.config.security.UserDetailsServiceImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private AjaxAuthSuccessHandler successHandler;

    @Resource
    private AjaxAuthFailureHandler failureHandler;

    @Resource
    private AjaxLogoutSuccessHandler logoutSuccessHandler;

    @Resource
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/static/**","/img/**","/layui/**", "/jss/**", "/css/**", "/file/**").permitAll()
//                .antMatchers("/hello", "/login", "/", "/IPerror","/main").permitAll()
//                .antMatchers("/visit/**").permitAll()
                .antMatchers("/user/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/braggart/**", "/photo/**", "/movie/**"
//                        , "/str/**", "/report/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/braggart/**", "/photo/**", "/movie/**"
//                        , "/str/**", "/report/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/braggart/**", "/photo/**", "/movie/**"
//                        , "/str/**", "/report/**").hasAnyAuthority("WORK","ATM")
//                .antMatchers("/admin/**","/prison/**").hasAnyAuthority("WORK","ATM")
//                .antMatchers("/worker/**").hasAnyAuthority("ATM")
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .failureHandler(failureHandler)
                .loginPage("/error.html")
                .loginProcessingUrl("/toLogin")
                .successHandler(successHandler).permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler).permitAll()
                .and()
                .httpBasic()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });
    }

}

