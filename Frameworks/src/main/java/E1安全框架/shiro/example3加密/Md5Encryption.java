package E1安全框架.shiro.example3加密;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author chengzhen
 * @date 2020/4/16
 * @time 下午2:13
 */
public class Md5Encryption {
    public static void main(String[] args) {
        String password = "123";
        String encodedPassword = new Md5Hash(password).toString();

        System.out.println(encodedPassword);
    }
}
