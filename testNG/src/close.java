import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class close {
	public void exit(){
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1");
		Jedis jedis = pool.getResource();
		try {
		    /// ��ʼʹ��
		    jedis.set("foo", "bar");
		    String foobar = jedis.get("foo");
		    jedis.zadd("sose", 0, "car"); 
		    jedis.zadd("sose", 0, "bike"); 
		    Set<String> sose = jedis.zrange("sose", 0, -1);
		} finally {
		    /// ʹ����󣬽����ӷŻ����ӳ�
		    if (null != jedis) {
		        jedis.close();
		    }
		}
		/// Ӧ���˳�ʱ���ر����ӳ�:
		pool.destroy();
	}
}