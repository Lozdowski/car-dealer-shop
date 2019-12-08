package cardealershop.databaseauth;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
@ConfigurationProperties("databaseauth")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private PasswordEncoder passwordEncoder;

    private CustomUserService customUserService;

    public SecurityConfig(PasswordEncoder passwordEncoder, CustomUserService customUserService) {
        this.passwordEncoder = passwordEncoder;
        this.customUserService = customUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()            // wlaczamy filtr autoryzacji
                .antMatchers("/login**", "/register**","/","/cars**").permitAll() // rejestrujemy wyjatek czyli wykluczamy z autoryzacji
                .and()
                .formLogin()            // wlaczamy obsluge logowania formularzu
                .loginPage("/login") // url do strony logowania
                .loginProcessingUrl("/sign")    // ustawiamy url dla formularza wewnatrz strony login.html
                .usernameParameter("username")      // nazwa inputa html , nazwa parametru wysylanego do  /sign
                .passwordParameter("password")
               // .successForwardUrl()                // nie brany pod uwage gdy jest Handler
                .successHandler((req,res,auth) -> {
                    for(GrantedAuthority g : auth.getAuthorities()){
                        System.out.println(g.getAuthority());
                    }
                    res.sendRedirect("/");
                })
                .failureForwardUrl("/login?error=zaloguj sie wac panie!").permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((req,res,auth) -> {
                    req.getSession().setAttribute("message","wylogowales sie mistrzowsko");
                    res.sendRedirect("/login");
                }).permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService)
                .passwordEncoder(passwordEncoder);


    }
}
