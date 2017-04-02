package com.sql.management.Service;

import com.sql.management.Model.Backup;
import java.util.ArrayList;


public class BackupServiceImpl implements BackupService {

	@Override
	public ArrayList<Backup> getAllBackups() {
		
		
		return com.sql.management.Util.getFiles.listAllBackups();
		
	}


}
