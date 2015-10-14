package sg.edu.nus.iss.vmcs.ca;

import sg.edu.nus.iss.vmcs.system.FilePropertyLoader;

public abstract class PropertyAbstractFactory {

	
	public abstract FilePropertyLoader getFilePropertyLoader(String fileType);
}
