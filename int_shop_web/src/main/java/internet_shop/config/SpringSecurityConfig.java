package internet_shop.config;

import internet_shop.services.auth.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan({"internet_shop.services"})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService authService() {
        return new AuthenticationService();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").access("permitAll()")
                .antMatchers("/welcome").access("permitAll()")
                .and().formLogin().loginPage("/login").usernameParameter("login").passwordParameter("password")
                .defaultSuccessUrl("/welcome").failureUrl("/access_denied").and()
                .logout().invalidateHttpSession(true).logoutUrl("logout").logoutSuccessUrl("/login");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService());
    }


}