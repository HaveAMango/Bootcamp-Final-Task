package lv.accenture.bootcamp.rardb.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MyUserDetailsService userDetailsService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth
                    .userDetailsService(userDetailsService)
                    .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.
    		authorizeRequests()
    		.antMatchers("/").permitAll()
    		.antMatchers("/login").permitAll()
    		.antMatchers("/movie/**").hasAuthority("USER").anyRequest().authenticated()
    		.and().formLogin().loginPage("/login").usernameParameter("myusername")
    		.failureUrl("/login?error=true")
    		.defaultSuccessUrl("/main");
//    	http.
//        authorizeRequests()
//        .antMatchers("/").permitAll()
//        .antMatchers("/login").permitAll()
//        .antMatchers("/registration").permitAll()
//        .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//        .authenticated().and().csrf().disable().formLogin()   
//        .loginPage("/login").failureUrl("/login?error=true")
//        .defaultSuccessUrl("/admin/home")
//        .usernameParameter("user_name")
//        .passwordParameter("password")
//        .and().logout()
//        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//        .logoutSuccessUrl("/login").and().exceptionHandling()
//        .accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
