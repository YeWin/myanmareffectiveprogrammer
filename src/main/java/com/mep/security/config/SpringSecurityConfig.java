package com.mep.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mep.security.service.AdminDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(WebSecurity web) throws Exception{		
		web.ignoring().antMatchers("/", "/searchArticle",  "/2**/**", "/articles",
				"/professional-programmer", "/test-driven-development", "/effective-java", 
				"/java7", "/about-us", "/contact-us", "/write-for-us", "/theme/**", "/webjars/**");
	}

	@Override
	protected void configure(HttpSecurity http)throws Exception{

		http.authorizeRequests()
			.antMatchers("/login",
						"/login-error",						
						"admin/**",
						"/auth").permitAll()	
			.anyRequest().authenticated()
		.and()
        
		//this config is require as website have to use embedded script.
        .headers().defaultsDisabled()
        .xssProtection().xssProtectionEnabled(false)
        .and()
        .and();

		http.formLogin()
			.loginProcessingUrl("/auth")		
			.loginPage("/login")				
			.failureForwardUrl("/login-error")	
			.defaultSuccessUrl("/login-success", true)
			.usernameParameter("adminEmail")			
			.passwordParameter("adminPassword")			
			.and();

		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
			.logoutSuccessUrl("/login")
			.invalidateHttpSession(true);
	}

	@Configuration
    protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

        @Autowired
        AdminDetailsServiceImpl adminDetailsServiceImpl;

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            
            auth.userDetailsService(adminDetailsServiceImpl)
            
            .passwordEncoder(passwordEncoder());
        }
    }
}
