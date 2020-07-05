package br.com.apiRest.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
   
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .anyRequest().authenticated()
        .and()
        .httpBasic();
  }
  
  @Override
  public void configure(AuthenticationManagerBuilder builder) throws Exception {
    builder
        .inMemoryAuthentication()
        .withUser("usuario1").password("123")
            .roles("USER")
        .and()
        .withUser("usuario2").password("123")
            .roles("USER");
  }
 
}
