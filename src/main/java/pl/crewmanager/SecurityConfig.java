package pl.crewmanager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.crewmanager.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/crewManager/**").permitAll()
                .antMatchers("/worker/**", "/contract/**", "/admin/**").authenticated()
                .and().formLogin().loginPage("/crewManager/login")
                .defaultSuccessUrl("/admin/home")
                .failureUrl("/crewManger/login")
                .and().logout().logoutUrl("/crewManager/logout")
        ;
        http.csrf().disable();
    }

    @Bean
    public MyUserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //wzorzec ścieżki przechowującej zasoby
    @Override
    public void configure(final WebSecurity web) {
        web.ignoring().antMatchers("/resources/**, \"/static/**\", \"/css/**\", \"/js/**\", \"/images/**");
    }
}
