package com.yq.scommonlib.base;

import android.os.Bundle;
import com.yq.scommonlib.manager.ActivityManager;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * author: Y_Qing
 * date: 2019/2/16
 */
public abstract class BaseActivity extends AutoLayoutActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.getInstance().removeActivity(this);
    }
}
