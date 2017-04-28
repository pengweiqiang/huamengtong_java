package net.shopin.hmtpdamw.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 解决错误界面的乱码异常
 * @author pengweiqiang
 *
 */
@Component
public class AExceptionHandler implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		response.setCharacterEncoding("UTF-8");
		System.out.println("0000000000000解决错误界面的乱码异常");
		return null;
	}
}
