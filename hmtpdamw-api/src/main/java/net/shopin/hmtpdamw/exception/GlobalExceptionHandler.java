package net.shopin.hmtpdamw.exception;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import net.shopin.hmtpdamw.apiresult.ApiPadResult;
import net.shopin.hmtpdamw.constants.InfoConstants.CodeInfo;

@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";
    Logger logger = LogManager.getLogger(this);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiPadResult defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
    	
    	StringBuilder sbParams = new StringBuilder();
		Enumeration<String> keys = req.getParameterNames(); 
		while(keys.hasMoreElements()) { 
		    String key = keys.nextElement(); 
		    sbParams.append(key+"="+req.getParameter(key)+"&");
		} 
		logger.info("error [ url = "+ req.getRequestURI() +" Method = " +req.getMethod()+" ] | "+"[ "+sbParams+" ]"); 
    	logger.error("XXXXXXXXXXXXXXXXXXXXXx"+e.toString());
    	e.printStackTrace();
        return ApiPadResult.N(CodeInfo.全局异常, e.getLocalizedMessage());
    }
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandlerModelAndView(HttpServletRequest req, Exception e) throws Exception {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName(DEFAULT_ERROR_VIEW);
//        return mav;
//    }
}
