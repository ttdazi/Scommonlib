package com.yq.scommonlib.base;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * author: Y_Qing
 * date: 2019/2/16
 */
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity)
            this.mActivity = (BaseActivity) context;
    }

    protected BaseActivity getHoldingActivity() {
        return this.mActivity;
    }

}
