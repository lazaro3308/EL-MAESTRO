package br.com.elmaestro.config;
import br.com.elmaestro.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
  @Bean PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(12); }
  @Bean UserDetailsService userDetailsService(CustomerRepository customers){
    return email -> customers.findByEmailIgnoreCase(email)
      .map(c -> User.withUsername(c.getEmail()).password(c.getPassword()).roles(c.getRole()).build())
      .orElseThrow(() -> new UsernameNotFoundException("Conta não encontrada"));
  }
  @Bean SecurityFilterChain security(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(a -> a
      .requestMatchers("/","/perfumes/**","/entrar","/cadastro","/css/**","/js/**","/images/**","/erro").permitAll()
      .requestMatchers("/admin/**").hasRole("ADMIN")
      .requestMatchers("/checkout/**","/minha-conta/**").authenticated()
      .anyRequest().permitAll())
      .formLogin(f -> f.loginPage("/entrar").defaultSuccessUrl("/",true).permitAll())
      .logout(l -> l.logoutSuccessUrl("/").permitAll())
      .build();
  }
}