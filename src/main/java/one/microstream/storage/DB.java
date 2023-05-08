package one.microstream.storage;

import one.microstream.domain.Company;
import one.microstream.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import one.microstream.storage.embedded.types.EmbeddedStorageManager;


public class DB
{
	public static EmbeddedStorageManager	storageManager;
	public final static Company				root	= new Company();
	
	static
	{		
		storageManager = EmbeddedStorageConfiguration.Builder()
			.setChannelCount(2)
			.setStorageDirectory("data")
			.createEmbeddedStorageFoundation()
			.createEmbeddedStorageManager(root)
			.start();
	}
}
