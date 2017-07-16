package cc.hobot.p2p.util;

/**
 * Created by cui on 17-7-16.
 */

public class StringUtils {

    public static boolean isEmpty(String str) {
        return (str == null || str.equals(""));
    }

    public static boolean isContains(String container, String str) {
        return container.contains(str);
    }
}
