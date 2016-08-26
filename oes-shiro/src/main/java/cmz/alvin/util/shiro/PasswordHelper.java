package cmz.alvin.util.shiro;

import cmz.alvin.pojo.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Created by e诺
 * on 16/7/29
 * Time 下午10:42
 */
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private static String algorighmName = "md5";
    private static final int hashIterations = 2;

    public static void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algorighmName, user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()), hashIterations).toHex();
        user.setPassword(newPassword);
    }
}
