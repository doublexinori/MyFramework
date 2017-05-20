import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;
import net.sf.json.JSONObject;

public class NewTest {
	private Jedis jedis;

	@BeforeTest
	public void f() {
		// 連接到Redis/Connect to the database
		jedis = new Jedis("127.0.0.1", 6379);
		// 無密碼驗證/No password verification
		// jedis.auth("");
		// 查看redis是否啟動/See if redis is started
		System.out.println("Server is running:" + jedis.ping());
	}

	@Test
	public void b() {
		int sum = 0;
		JSONObject jsonObject = JSONObject.fromObject(jedis.get("5d4fc954-9b04-4ca7-baf8-050fa133ca9f"));
		System.out.println(jsonObject);
		// System.out.println(jsonObject.get("is_promote"));
		// JSONObject jsonObject1 = JSONObject.fromObject(jedis.get("name"));
		// System.out.println(jsonObject1.get("is_promote"));
	}

	@Test
	public void c() {
		int sum = 0;
		JSONObject[] keys = { JSONObject.fromObject(jedis.get("5d4fc954-9b04-4ca7-baf8-050fa133ca9f")),
				JSONObject.fromObject(jedis.get("f2a64a8a-f09b-44db-8f55-14bb816c839a")),
				JSONObject.fromObject(jedis.get("a16954b1-6be8-4f8e-809e-420c09d003de")),
				JSONObject.fromObject(jedis.get("b6f2bceb-eaa7-4665-97ea-3ff07959e29b")),
				JSONObject.fromObject(jedis.get("d0856778-7004-4516-83bb-41f2f2182df1")) };
		for (int i = 0; i < jedis.dbSize() - 1; i++) {
			if ((boolean) keys[i].get("is_promote")) {
				sum += 1;
			}
		}
		System.out.println("ture:" + sum);
	}

	@AfterTest
	public void d() {
	}
}
