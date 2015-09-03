import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;


public class Demo {

	public static void main(String[] args) {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.addServer().port(11322).host("localhost");
		
		RemoteCache<String, String> cache = new RemoteCacheManager(builder.build()).getCache("default");	
	
		
		cache.put("one", "one");
		cache.put("two", "two");
		cache.put("three", "three");
		

		System.out.println("Cache size is " + cache.size());
		
		//cache.put("three", "four");
		//cache.put("three", "three");
		cache.replace("three", "four");

		
		System.out.println("Value of key 'three' is " + cache.get("three"));
		
		//cache.clear();
		
	}

}