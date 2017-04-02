package com.sql.management.Util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.*;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPReply;



public class DatabaseConnection {
	
	@Test
	public void test() {
		backup("Test4", "passWord");
	}
	
	
	public void zipAndCleanUpBakFiles(String zipName) {
		
		
		
	}
	
	public static boolean isOnline(String instance, String saPassword) {
		Connection conn = null;
		
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            String dbURL = "jdbc:sqlserver://127.0.0.1\\"+ instance;
            String user = "sa";
            String pass = saPassword;
            conn = DriverManager.getConnection(dbURL, user, pass);
            Statement stmt = conn.createStatement();
            String query = "Select TOP * FROM Infocentre.dbo.people";
            ResultSet rs = stmt.executeQuery(query);
            
            if (!rs.isBeforeFirst() ) {    
                return false; 
            }       	

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
        }
		return true;
	}
	
	
	public static void connect(String instance, String saPassword, String query)  {
		Connection conn = null;
		
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            String dbURL = "jdbc:sqlserver://127.0.0.1\\"+ instance;
            String user = "sa";
            String pass = saPassword;
            conn = DriverManager.getConnection(dbURL, user, pass);
            Statement stmt = conn.createStatement();
            stmt.execute("EXEC DatabaseBackups");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
        }
	}
	

	
	public static void backup(String instance, String saPassword) {
		
		ArrayList<String> queryBuilder = new ArrayList<String>();
		queryBuilder.add("DECLARE @name VARCHAR(50) -- database name");
		queryBuilder.add("DECLARE @path VARCHAR(256) -- path for backup files");
		queryBuilder.add("DECLARE @fileName VARCHAR(256) -- filename for backup");
		queryBuilder.add("-- specify database backup directory");
		queryBuilder.add("SET @path = 'C:\\SQLBackups\\'");
		queryBuilder.add("-- specify filename format");
		queryBuilder.add("SELECT @fileDate = CONVERT(VARCHAR(20),GETDATE(),112)");
		queryBuilder.add("DECLARE db_cursor CURSOR FOR");
		queryBuilder.add("SELECT name");
		queryBuilder.add("FROM master.dbo.sysdatabases");
		queryBuilder.add("WHERE name NOT IN ('master','model','msdb','tempdb')  -- exclude these databases");
		queryBuilder.add("OPEN db_cursor");
		queryBuilder.add("FETCH NEXT FROM db_cursor INTO @name");
		queryBuilder.add("WHILE @@FETCH_STATUS = 0");
		queryBuilder.add("BEGIN");
		queryBuilder.add("SET @fileName = @path + @name + '_' + @fileDate + '.BAK'");
		queryBuilder.add("BACKUP DATABASE @name TO DISK = @fileName");
		queryBuilder.add("FETCH NEXT FROM db_cursor INTO @name");
		queryBuilder.add("END");
		queryBuilder.add("CLOSE db_cursor");
		queryBuilder.add("DEALLOCATE db_cursor");
		
		String query = "DECLARE @name VARCHAR(50) -- database name   " +
				"DECLARE @path VARCHAR(256) -- path for backup files   " +
				"DECLARE @fileName VARCHAR(256) -- filename for backup   " +
				"DECLARE @fileDate VARCHAR(20) -- used for file name " +
				"-- specify database backup directory " +
				"SET @path = 'C:\\SQLBackups\\'   " +
				"-- specify filename format " +
				"SELECT @fileDate = CONVERT(VARCHAR(20),GETDATE(),112)  " +
				"DECLARE db_cursor CURSOR FOR   " +
				"SELECT name  " +
				"FROM master.dbo.sysdatabases  " +
				"WHERE name NOT IN ('master','model','msdb','tempdb')  -- exclude these databases " +
				"OPEN db_cursor    " +
				"FETCH NEXT FROM db_cursor INTO @name    " +
				"WHILE @@FETCH_STATUS = 0    " +
				"BEGIN    " +
				"       SET @fileName = @path + @name + '_' + @fileDate + '.BAK'   " +
				"       BACKUP DATABASE @name TO DISK = @fileName   " +
				"       FETCH NEXT FROM db_cursor INTO @name    " +
				"END    " +
				"CLOSE db_cursor    " +
				"DEALLOCATE db_cursor ";
				
		connect(instance, saPassword, query);
	}
	
	public static void clear(String instance, String saPassword) {
		
	}
	
	public static void Restore(String instance, String saPassword) {
		
	}
	
    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
    
    private static void makeDirectory(String directoryName) {

    	 String server = "10.0.10.1";
         int port = 21;
         String user = "administrator";
         String pass = "ApplePostit7";
	        FTPClient ftpClient = new FTPClient();
	        try {
	            ftpClient.connect(server, port);
	            showServerReply(ftpClient);
	            int replyCode = ftpClient.getReplyCode();
	            if (!FTPReply.isPositiveCompletion(replyCode)) {
	                System.out.println("Operation failed. Server reply code: " + replyCode);
	                return;
	            }
	            boolean success = ftpClient.login(user, pass);
	            showServerReply(ftpClient);
	            if (!success) {
	                System.out.println("Could not login to the server");
	                return;
	            }
	            // Creates a directory	   
	            System.out.println(ftpClient.printWorkingDirectory());
	            success = ftpClient.makeDirectory(directoryName);
	            showServerReply(ftpClient);
	            if (success) {
	                System.out.println("Successfully created directory: " + directoryName);
	            } else {
	                System.out.println("Failed to create directory. See server's reply.");
	            }
	            // logs out
	            ftpClient.logout();
	            ftpClient.disconnect();
	        } catch (IOException ex) {
	            System.out.println("Oops! Something wrong happened");
	            ex.printStackTrace();
	        }
	}
		
    }
    
    
	

