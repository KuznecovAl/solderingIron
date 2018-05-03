package internet_shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").access("permitAll()")
                .antMatchers("/welcome").access("permitAll()")
                .and().formLogin().loginPage("/login").usernameParameter("login").passwordParameter("password")
                .defaultSuccessUrl("/welcome").failureUrl("/access_denied").and()
                .logout().invalidateHttpSession(true).logoutUrl("logout").logoutSuccessUrl("/login");

    }

}