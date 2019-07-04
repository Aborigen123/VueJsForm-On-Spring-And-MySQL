package project.with.add.data;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CorsFilter extends OncePerRequestFilter {//для того щоб Rest міг нормально працювати

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
response.setHeader("Access-Control-Allow-Origin", "*");//буде передаватися з зірочкою дані пишемо зірочку для того щоб секюріті не блокувало доступ які не звязані з нашим томкетом
filterChain.doFilter(request, response);
		
	}

}
