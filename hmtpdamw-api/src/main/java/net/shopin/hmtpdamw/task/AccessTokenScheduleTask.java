package net.shopin.hmtpdamw.task;
//package net.shopin.jxpdamw.task;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.alibaba.druid.Constants;
//import com.alibaba.fastjson.JSONObject;
//
//import net.rubyeye.xmemcached.MemcachedClient;
//
//
///**
// * 
// * @author 彭威强
// * 定时刷新access_token
// */
//@Component
//public class AccessTokenScheduleTask {
//	
//	@Autowired
//	MemcachedClient memcachedClient;
//	
//	private static Logger logger = LogManager.getLogger(AccessTokenScheduleTask.class);
//	
//	
////   @Scheduled(fixedRate = 5000)
////	 @Scheduled(cron = "0/5 * * * * ?") // 每20秒执行一次
////	 public void reportCurrentTimeCron() throws InterruptedException {
////	        System.out.println();
////	    }
//
//	@Scheduled(cron = "0 0 0/2 * * ?") // 每20秒执行一次 (cron = "0/5 * * * * ?")
//	public void refreshAccessToken(){
//		
//	}
//			
//
//}
