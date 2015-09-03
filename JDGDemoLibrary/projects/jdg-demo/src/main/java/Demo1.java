import org.infinispan.Cache;
import org.infinispan.manager.DefaultCacheManager;


public class Demo1 {

	public static void main(String[] args) {
		Cache<Object, Object> cache = new DefaultCacheManager().getCache();
		cache.put("one", "one");
		cache.put("two", "two");
		//cache.put("three", "three");
		
		cache.putIfAbsent("three", "A new value for key three");
		cache.replace("three", "Yet another value for key three");
		
		//cache.remove("three");
		
		System.out.println(String.format("Cache size is %s", cache.size()));
		System.out.println(String.format("Value for key three is %s", cache.get("three")));
		
		System.out.println(String.format("El valor de 1 es: %s", cache.get("one")));
	}

}