package com.johnwu.onlineStoreFrontEnd.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	
	//this is the absolute path that represents the project location
	private static final String ABS_PATH = "D:/eclipse/projects/myOnlineShopping/onlineStoreFrontEnd/src/main/webapp/assetsOfBootstrap/pictures/";
	
	
	//this is the real path where the tomcat deploy this application, get this real path through HttpServletRequest
	private static String REAL_PATH = "";


public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		// get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assetsOfBootstrap/pictures/");

		
		// to make sure all the directory exists
		// if the directory doex not exist please create the directories
		if(!new File(ABS_PATH).exists()) {
			// create the directories
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()) {
			// create the directories
			new File(REAL_PATH).mkdirs();
		}
				

		try {
			// server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			// project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		}
		catch(IOException ex) {
			
		}
		
		
	}
}
