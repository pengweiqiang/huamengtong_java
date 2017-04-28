package net.shopin.hmtpdamw.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.shopin.hmtpdamw.apiresult.ApiPadResult;
import net.shopin.hmtpdamw.constants.Constants;
import net.shopin.hmtpdamw.constants.InfoConstants;
import net.shopin.hmtpdamw.constants.InfoConstants.CodeInfo;
import net.shopin.hmtpdamw.util.DateUtils;

/**
 * 用户拦截器（校验用户名、密码、mac地址、ip地址、APP版本号、）
 * 
 * @author pengweiqiang
 *
 */
public class UserInterceptor extends HandlerInterceptorAdapter {

	Logger logger = LogManager.getLogger(this);
	private long startTime = 0;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		startTime = System.currentTimeMillis();

		// 1.检验访问接口有效性
		String path = request.getServletPath();

		StringBuilder sbParams = new StringBuilder();
		Enumeration<String> keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			sbParams.append(key + "=" + request.getParameter(key) + "&");
		}
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		logger.info(method.getDeclaringClass().getName() + "." + method.getName() + " [ url = " + path + " Method = "
				+ request.getMethod() + " ] | " + "[ " + sbParams + " ]");
		if (Constants.ERROR_URL.equals(path)) {// 接口地址错误或者参数错误
			outPrint(response, handler, InfoConstants.CodeInfo.地址不合法);
			return false;
		}

		String ipAddress = request.getParameter(Constants.IP_ADDRESS);
		String appVersionName = request.getParameter(Constants.APP_VERSION_NAME);
		String macAddress = request.getParameter(Constants.MAC_ADDRESS);

		if (StringUtils.isEmpty(ipAddress)) {
			outPrint(response, handler, InfoConstants.CodeInfo.IP地址不能为空);
			return false;
		} else if (StringUtils.isEmpty(appVersionName)) {
			outPrint(response, handler, InfoConstants.CodeInfo.APP版本号不能为空);
			return false;
		} else if (StringUtils.isEmpty(macAddress)) {
			outPrint(response, handler, InfoConstants.CodeInfo.MAC地址不能为空);
			return false;
		}
		if (!path.startsWith(Constants.LOGIN_URL)) {// 登陆接口

			String userName = request.getParameter(Constants.USER_NAME);
			String password = request.getParameter(Constants.PASSWORD);
			String optUserSid = request.getParameter(Constants.OPT_USER_SID);

			String shopSid = request.getParameter(Constants.SHOP_SID);

			if (StringUtils.isEmpty(userName)) {
				outPrint(response, handler, InfoConstants.CodeInfo.用户名不能为空);
				return false;
			} else if (StringUtils.isEmpty(password)) {
				outPrint(response, handler, InfoConstants.CodeInfo.密码不能为空);
				return false;
			} else if (StringUtils.isEmpty(optUserSid)) {
				outPrint(response, handler, InfoConstants.CodeInfo.用户名SID不能为空);
				return false;
			} else if (StringUtils.isEmpty(shopSid)) {
				outPrint(response, handler, InfoConstants.CodeInfo.门店ID不能为空);
				return false;
			}
		}

		return super.preHandle(request, response, handler);
	}

	private void outPrint(HttpServletResponse response, Object handler, String logInfo) {
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json; charset=utf-8");
			out = response.getWriter();
			out.append(logInfo);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
			long costSeconds = System.currentTimeMillis() - startTime;
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			logger.info(method.getDeclaringClass().getName() + "." + method.getName() + " "
					+ DateUtils.PrintTimeGap("", costSeconds) + logInfo + "\r\n");
		}
	}

	private void outPrint(HttpServletResponse response, Object handler, CodeInfo codeInfo) {
		outPrint(response, handler, ApiPadResult.N(codeInfo, "").toString());
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
		// HandlerMethod handlerMethod = (HandlerMethod) handler;
		// Method method = handlerMethod.getMethod();
		// long costSeconds = System.currentTimeMillis()-startTime;
		// logger.info(method.getDeclaringClass().getName() + "." +
		// method.getName()+DateUtils.PrintTimeGap(" ",costSeconds)+"\r\n");
	}
}
