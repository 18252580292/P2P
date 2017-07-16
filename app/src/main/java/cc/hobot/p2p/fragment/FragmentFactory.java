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
        if (fragment != null) {
            return fragment;
        }
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new InvestFragment();
                break;
            case 2:
                fragment = new MeFragment();
                break;
            case 3:
                fragment = new MoreFragment();
                break;
        }

        fms.put(position, fragment);

        return fragment;
    }
}
