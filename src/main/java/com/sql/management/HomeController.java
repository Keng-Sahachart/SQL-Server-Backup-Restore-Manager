package com.sql.management;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sql.management.DAO.DatabaseInstanceDAO;
import com.sql.management.Model.Backup;
import com.sql.management.Model.DatabaseInstance;
import com.sql.management.Service.BackupService;
import com.sql.management.Service.DatabaseInstanceService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
    
    @Autowired
    DatabaseInstanceService dis;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		ArrayList<Backup> list = com.sql.management.Util.getFiles.listAllBackups();
	 	model.addAttribute("list", list);
	 	List<DatabaseInstance> dbInstances = dis.findAllInstances();
	 	model.addAttribute("dbs", dbInstances);

		
		return "index";
	}
	
}
