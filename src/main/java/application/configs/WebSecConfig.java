package application.configs;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Web Security Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // következő: bejelentkezett felhasználó ÉS READ joga van
                .antMatchers("/game").hasAuthority("ADD")
                // következő: bejelentkezett, tök mindegy, milyen joggal
                //.antMatchers("/game").authenticated()
                // következő: bárki (nem kell bejelentkezés sem)
                .anyRequest().permitAll();
    }

}
