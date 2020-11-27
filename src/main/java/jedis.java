import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import redis.clients.jedis.Jedis;

public class jedis {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("172.17.0.2");
//
//        /*
//        문자열
//         */
//        System.out.println("문자열 실습");
//        jedis.set("foo","bar");
//        jedis.set("bobo","fafa");
//        System.out.println(jedis.get("foo"));
//        System.out.println(jedis.get("bobo"));
//
//        /*
//        리스트
//         */
//        System.out.println("리스트 실습");
//        jedis.lpush("name", "kbj");
//        jedis.lpush("name", "kjj");
//        System.out.println(jedis.rpop("name"));
//        System.out.println(jedis.rpop("name"));
//
//        /*
//        해쉬
//         */
//        System.out.println("해쉬 실습");
//        jedis.hset("kbj", "name", "byungjun");
//        jedis.hset("kbj", "job", "software engineer");
//        jedis.hset("kbj", "hobby", "running");
//        System.out.println(jedis.hget("kbj","name"));
//        Map<String, String> fields = jedis.hgetAll("kbj");
//        fields.forEach((k,v)-> System.out.println(k+" : "+v));
        System.out.println(LocalDate.now().toString());
          Map<String, String> fields = jedis.hgetAll("1");
          fields.forEach((k,v)-> System.out.println(k+" : "+v));
//        /*
//        집합
//         */
//        System.out.println("집합 실습");
//        jedis.sadd("name", "kbj");
//        jedis.sadd("name", "kkj");
//        jedis.sadd("name", "jjo");
//        jedis.sadd("name", "jjo");
//        Set<String> names = jedis.smembers("name");
//        names.stream().forEach(System.out::println);
//
//        /*
//        정렬 집합
//         */
//        System.out.println("정렬 집합 실습");
//        jedis.zadd("scores", 100, "Student1");
//        jedis.zadd("scores", 80, "Student2");
//        jedis.zadd("scores", 12, "Student3");
//        Set<String> scores =jedis.zrange("scores",0,-1);
//        scores.stream().forEach(System.out::println);

    }

}
