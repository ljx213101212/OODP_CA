package sg.edu.nus.iss.vmcs.ca;

import sg.edu.nus.iss.vmcs.system.Environment;

public class PropertyFactoryProducer {

	
	public static PropertyAbstractFactory getFactory(String choice){
		if (choice.equalsIgnoreCase("file")){
			return new FileFactory();
		}else if (choice.equalsIgnoreCase("something")){
			return new somethingFactory();
		}
		return null;
	}
}
