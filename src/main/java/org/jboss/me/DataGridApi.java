package org.jboss.me;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfiguration;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.CacheContainer;
import org.infinispan.manager.DefaultCacheManager;

public class DataGridApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CacheContainer cacheManager = getCacheManager();
		Cache<String, String> cache = cacheManager.getCache("api");
		
		cache.put("abc", "123");
		if (cache.size() == 1) System.out.println("cache has: " + cache.size() + 
				" number of values");
		else throw new RuntimeException();
		
		if (cache.size() == 1) System.out.println("cache has: " + cache.size() + 
				" number of values");
		else throw new RuntimeException();
		
		if(cache.get("abc") != null) System.out.println("cache has value: " + cache.get("abc") + 
				" for key \"abc\"");
		else throw new RuntimeException();
		
		cache.remove("abc");
		if (cache.isEmpty()) System.out.println("The key \"abc\" has been removed");
		else throw new RuntimeException();
		
		cache.stop();
			
		
	}

	private static CacheContainer getCacheManager() {
		// TODO Auto-generated method stub
		GlobalConfiguration globalConfig = new GlobalConfigurationBuilder()
		.build();
		
		Configuration config = new ConfigurationBuilder()
		.eviction().maxEntries(1)
		.persistence().passivation(false).addSingleFileStore().purgeOnStartup(true)
		.build();
		
		return new DefaultCacheManager(globalConfig, config, true);
	}

}
