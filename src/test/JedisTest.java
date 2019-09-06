import com.example.Demo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.Set;

@RunWith(JUnit4.class)
@SpringBootTest
public class JedisTest {
    Jedis jedis;

    @Before
    public void connectionTest() {
        jedis = new Jedis("127.0.0.1", 6379);//redis的地址以及连接端口
        //jedis.auth("123456");
        jedis.connect();
    }

    @Test
    public void keyTest(){

        /*第二个Key的Value会把前面相同Key的Value覆盖*/
        /*jedis.set("key", "values");
        jedis.set("key2", "values");*/
        System.out.println(jedis.exists("key"));// 判断是否存在
        Set<String> keys = jedis.keys("*"); //列出所有的key
        System.out.println(keys);
        System.out.println("Key的数量:"+jedis.dbSize());

    }


}
