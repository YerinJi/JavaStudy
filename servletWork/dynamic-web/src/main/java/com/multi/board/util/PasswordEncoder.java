// util/PasswordEncoder.java
package com.multi.board.util;
import org.mindrot.jbcrypt.BCrypt;
public class PasswordEncoder {
    public static String hash(String raw) { return BCrypt.hashpw(raw, BCrypt.gensalt(12)); }
    public static boolean matches(String raw, String hashed) { return BCrypt.checkpw(raw, hashed); }
}
