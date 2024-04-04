package one.microstream.storage;

import org.eclipse.store.storage.embedded.configuration.types.EmbeddedStorageConfiguration;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;

import one.microstream.domain.Company;


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
