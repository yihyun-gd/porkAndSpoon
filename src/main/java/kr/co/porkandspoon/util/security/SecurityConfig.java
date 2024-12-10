package kr.co.porkandspoon.util.security;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		logger.info("시큐리티 초기 설정");
		
		http.authorizeHttpRequests()
		.antMatchers("/resources/**").permitAll() // resources 하위 폴더 허용
		.antMatchers("/", "/login").permitAll() // 메인 페이지, 로그인 요청 허용
		.anyRequest().authenticated(); // 그 외 요청은 검토
		
		
		// 시큐리티 기본 기능 제거 (csrf 제거)
		http.httpBasic().disable().csrf().disable();
		return http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
