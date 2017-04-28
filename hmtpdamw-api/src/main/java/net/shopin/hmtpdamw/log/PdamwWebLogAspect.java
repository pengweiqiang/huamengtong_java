package net.shopin.hmtpdamw.log;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import net.shopin.hmtpdamw.util.DateUtils;

@Aspect
@Component
public class PdamwWebLogAspect {
	
	private static Logger logger = LogManager.getLogger(PdamwWebLogAspect.class.getName());
	
	ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    
    @Pointcut("execution(* net.shopin.jxpdamw.*.*Controller.*(..))")
    public void webLog(){}
    
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        // 记录下请求内容
//	    logger.info("URL : " + request.getRequestURL().toString());
//	    logger.info("HTTP_METHOD : " + request.getMethod());
	    String path = request.getServletPath();
//	    logger.info("IP : " + request.getRemoteAddr());
//	    logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName()+ "." + joinPoint.getSignature().getName());
//	    logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
	    String method = request.getMethod();
	    
	    
	  //获取所有参数方法一：
	    StringBuilder sbParams = new StringBuilder();
		Enumeration<String> keys = request.getParameterNames(); 
		while(keys.hasMoreElements()) {
		    String key = keys.nextElement(); 
		    sbParams.append(key+"="+request.getParameter(key)+"&");
		}
		
		if ("POST".equals(method)) {
            Object[] paramsArray = joinPoint.getArgs();
            String params = argsArrayToString(paramsArray);
            sbParams.append(" post="+params);
        }else{            
        	Map<?, ?> paramsMap = (Map<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        	sbParams.append(paramsMap.toString());
        }
		
		logger.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()+" [ url = "+ path +" Method = " +method+" ] | "+"[ "+sbParams+" ]");
    }
        
    /**
     * 在方法正常执行通过之后执行的通知叫做返回通知
     * 可以返回到方法的返回值 在注解后加入returning
     * @param joinPoint
     */
    @AfterReturning(value="execution(* net.shopin.jxpdamw.*.*Controller.*(..))",returning="result")
    public void afterReturn(JoinPoint joinPoint,Object result ){
        Signature signature = joinPoint.getSignature();
      
        long costSeconds = System.currentTimeMillis()-startTime.get();
		logger.info(signature.getDeclaringTypeName() + "." + signature.getName()+DateUtils.PrintTimeGap(" ",costSeconds)+"【返回结果:"+JSON.toJSONString(result, SerializerFeature.WriteNullStringAsEmpty)+"】"+"\r\n");
    }
    
    /**
     * 在目标方法非正常执行完成 发生异常 抛出异常的时候会走此方法
     * 获得异常可以用throwing
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value="execution(* net.shopin.jxpdamw.*.*Controller.*(..))",throwing="ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex ){
    	Signature signature = joinPoint.getSignature();
    	ex.printStackTrace();
//        long costSeconds = System.currentTimeMillis()-startTime.get();
        logger.error("xxxxxxxxxxxxx"+"执行了【"+signature.getDeclaringTypeName() + "." + signature.getName()+"方法发生异常......】"+"【异常报告:"+ex+"】");
    }
    
    /**
     * 请求参数拼装
     * 
     * @param paramsArray
     * @return
     */
    private String argsArrayToString(Object[] paramsArray) {
        StringBuffer params = new StringBuffer();
        if (paramsArray != null && paramsArray.length > 0) {
            for (int i = 0; i < paramsArray.length; i++) {
            	try{
            		Object object = paramsArray[i];
            		if(object!=null){
            			params.append(JSON.toJSONString(paramsArray[i])+" --- ");
            		}
            	}catch(Exception e){
//            		e.printStackTrace();
            	}
            }
        }
        return params.toString();
    }
    
}

