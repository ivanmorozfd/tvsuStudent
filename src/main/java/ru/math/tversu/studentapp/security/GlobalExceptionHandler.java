package ru.math.tversu.studentapp.security;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	private JwtTokenRepository jwtTokenRepository;

	@ExceptionHandler({AuthenticationException.class, MissingCsrfTokenException.class, InvalidCsrfTokenException.class,
			SessionAuthenticationException.class})
	public ErrorInfo handleAuthenticationException(RuntimeException ex, HttpServletRequest request,
												   HttpServletResponse response) {
		jwtTokenRepository.clearToken(response);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		return new ErrorInfo(UrlUtils.buildFullRequestUrl(request), "error.authorization");
	}

	@Getter
	public class ErrorInfo {
		private final String url;
		private final String info;

		ErrorInfo(String url, String info) {
			this.url = url;
			this.info = info;
		}
	}
}
