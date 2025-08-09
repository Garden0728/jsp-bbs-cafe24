package user.security;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    public static String hash(String plain) {
        return BCrypt.hashpw(plain, BCrypt.gensalt(10));
    }
    public static boolean matches(String plain, String hashed) {
        return BCrypt.checkpw(plain, hashed);
    }
}
