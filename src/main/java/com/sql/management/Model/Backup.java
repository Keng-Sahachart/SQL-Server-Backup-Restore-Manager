package com.sql.management.Model;


import java.util.Date;

public class Backup  {
	
	private String fileName;
	private long fileSize;
	private String directory;
	private Date timeStamp;
	

	
	public Date getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Date date) {
		this.timeStamp = date;
	}


	public String getFileName() {
		return fileName;
	}
	
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	public double getFileSize() {
		return fileSize;
	}
	
	public void setFileSize(long fileSize) {
	    long MEGABYTE = 1024L * 1024L;
	    this.fileSize = fileSize / MEGABYTE;
	}
	
	public String getDirectory() {
		return directory;
	}
	
	public void setDirectory(String directory) {
		this.directory = directory;
	}


		
}
