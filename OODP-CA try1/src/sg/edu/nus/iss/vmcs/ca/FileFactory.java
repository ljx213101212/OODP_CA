package sg.edu.nus.iss.vmcs.ca;

import sg.edu.nus.iss.vmcs.system.CashPropertyLoader;
import sg.edu.nus.iss.vmcs.system.DrinkPropertyLoader;
import sg.edu.nus.iss.vmcs.system.Environment;
import sg.edu.nus.iss.vmcs.system.FilePropertyLoader;

public class FileFactory extends PropertyAbstractFactory {
	
	

	public FilePropertyLoader getFilePropertyLoader(String fileType) {
		
		if (fileType == "drink"){
			String fileName = Environment.getDrinkPropFile();
			return new DrinkPropertyLoader(fileName);
		}else if (fileType == "cash"){
			String fileName = Environment.getCashPropFile();
			return new CashPropertyLoader(fileName);
		}
		
		return null;
	}
}
