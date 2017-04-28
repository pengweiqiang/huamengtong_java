package net.shopin.hmtpdamw.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

  public void addInterceptors(InterceptorRegistry registry) {
	  registry.addInterceptor(new UserInterceptor())
//	  .addPathPatterns("/user/**")
//	  .excludePathPatterns("/order/*")
	  ;//要拦截的请求
	  
//	  registry.addInterceptor(new UserInterceptor()).addPathPatterns("/xx/**")//要拦截的请求
//
//      .excludePathPatterns("/xxx/*");//不拦截的请求
//      registry.addInterceptor(xxxInterceptor）.addPathPatterns("xxx/xx")//推荐
	  
//      registry.addInterceptor(new HandlerInterceptorAdapter() {
//
//          @Override
//          public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
//                                   Object handler) throws Exception {
//              System.out.println("interceptor====222");
//              return true;
//          }
//      }).addPathPatterns("/*");
  }
}
