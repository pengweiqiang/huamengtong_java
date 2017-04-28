package net.shopin.hmtpdamw.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import net.shopin.hmtpdamw.config.ApiUrlConfig;

public class BaseController {
	protected Logger logger = LogManager.getLogger(this);
	
	@Autowired
	ApiUrlConfig apiUrl;
}
