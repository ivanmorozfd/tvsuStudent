package ru.math.tversu.studentapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import ru.math.tversu.studentapp.security.JwtCsrfFilter;
import ru.math.tversu.studentapp.security.JwtTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenRepository jwtTokenRepository;

	@Autowired
	private DataSource dataSource;

	@Autowired
	@Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver resolver;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
				.dataSource(dataSource)
				.usersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username=?")
				.authoritiesByUsernameQuery("SELECT username, role FROM user WHERE username=?")
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.NEVER)
				.and()
				.addFilterAt(new JwtCsrfFilter(jwtTokenRepository, resolver), CsrfFilter.class)
				.csrf().ignoringAntMatchers("/**")
				.and()
				.authorizeRequests()
				.antMatchers("/auth/login")
				.authenticated()
				.and()
				.httpBasic()
				.authenticationEntryPoint(
						((request, response, e) -> resolver.resolveException(request, response, null, e)));
	}
}