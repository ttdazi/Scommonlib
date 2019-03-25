package com.aidazi.scommonlib.lazy;

import com.aidazi.scommonlib.base.BaseFragment;

/**
 * 控制当前fragment，进入当前界面请求唯一，
 * 仅仅试用在hide show 方法中使用。
 * date: 2019/2/27
 */
public abstract class SLazyFragment extends BaseFragment {
    public boolean isShow = true;

    @Override
    public void onStart() {
        super.onStart();
        if (isShow) {
            loadData();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        isShow = !hidden;
        if (isShow) loadData();
    }


    public abstract void loadData();
}
