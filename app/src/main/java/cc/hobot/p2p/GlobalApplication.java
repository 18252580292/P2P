package cc.hobot.p2p;

import android.app.Application;
import android.content.Context;

/**
 * Created by cui on 17-7-16.
 */

public class GlobalApplication extends Application {
    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }
}
