import java.util.HashMap;

/**
 * @author yang
 * @create 2020-03-21 14:35
 */
public class Test01 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("age",18);
        hashMap.put("score",86);
        hashMap.put("major","computer");

        String major = (String) hashMap.get("major");
        System.out.println("major = " + major);
        System.out.println("java测试");

    }
}
