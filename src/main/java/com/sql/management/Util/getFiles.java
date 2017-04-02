package com.sql.management.Util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;

import com.sql.management.Model.Backup;

public class getFiles {
 
    public static ArrayList<Backup> listAllBackups() {
        String server = "127.0.0.1";
        int port = 21;
        String user = "user";
        String pass = "password";
        ArrayList<Backup> list = new ArrayList<Backup>();
 
        FTPClient ftpClient = new FTPClient();
 
        try {
 
            ftpClient.connect(server, port);
            showServerReply(ftpClient);
 
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Connect failed");
                return null;
            }
 
            boolean success = ftpClient.login(user, pass);
            showServerReply(ftpClient);
 
            if (!success) {
                System.out.println("Could not login to the server");
                return null;
            }
 
            // Lists files and directories
            
            FTPFile[] files1 = ftpClient.listFiles(".");
            System.out.println("Results total is: " + files1.length);
            
            printFileDetails(files1);
            System.out.println(ftpClient.printWorkingDirectory());
            for (FTPFile file : files1) {
            	 if (files1 != null && files1.length > 0) {
            		if(file.getName().endsWith(".zip")) {
            		Backup b = new Backup();
            		b.setTimeStamp(file.getTimestamp().getTime());
            		b.setFileName(file.getName());
            		b.setFileSize(file.getSize());
            		b.setDirectory(file.getLink());           	
            		list.add(b);
            	}
            	 }
            }
            System.out.println(list);
 
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        } finally {
            // logs out and disconnects from server
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		return list;
    }
 
    private static void printFileDetails(FTPFile[] files) {
        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (FTPFile file : files) {
            String details = file.getName();
            if (file.isDirectory()) {
                details = "[" + details + "]";
            }
            details += "\t\t" + file.getSize();
            details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());
 
            System.out.println(details);
        }
    }
 
    private static void printNames(String files[]) {
        if (files != null && files.length > 0) {
            for (String aFile: files) {
                System.out.println(aFile);
            }
        }
    }
 
    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
}