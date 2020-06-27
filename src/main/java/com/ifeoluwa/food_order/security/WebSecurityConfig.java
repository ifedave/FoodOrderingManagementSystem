package com.ifeoluwa.food_order.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  CustomSuccessHandler customSuccessHandler;

  @Autowired
  private UserDetailsService userDetailsService;
  
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  };
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	 http.authorizeRequests().antMatchers( "/home", "/index").hasAnyRole("ADMIN","CUSTOMER", "DELIVERY_AGENT") //.anyRequest().hasAnyRole("ADMIN", "USER")
	 .antMatchers("/admin/**").hasRole("ADMIN")
             .antMatchers("/customer**").hasRole("CUSTOMER")
//             .antMatchers("/customer**").hasAnyRole("CUSTOMER","ADMIN")
             .antMatchers("/delivery**").hasRole("DELIVERY_AGENT")
	 .and()
     .authorizeRequests().antMatchers("/login**").permitAll()
     .and()
     .formLogin().loginPage("/login").loginProcessingUrl("/loginAction").successHandler(customSuccessHandler).permitAll()
     .and()
     .logout().permitAll()
     .and()
     .csrf().disable().exceptionHandling().accessDeniedPage("/access_denied");
  }
}
