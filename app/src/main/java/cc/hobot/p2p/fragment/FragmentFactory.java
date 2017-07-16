package cc.hobot.p2p.fragment;

import android.support.v4.app.Fragment;
import android.util.SparseArray;

/**
 * Created by cui on 2017/7/16.
 */

public class FragmentFactory {
    private static SparseArray<Fragment> fms = new SparseArray<>();

    public static Fragment getFragment(int position) {
        Fragment fragment = fms.get(position);
        if(fragment != null) {
            return fragment;
        }
        switch (position) {
            case 0:
//                fragment = new
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
