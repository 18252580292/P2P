package cc.hobot.p2p.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by cui on 17-7-16.
 */

public class ToastUtils {

    public static void showToastShort(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
