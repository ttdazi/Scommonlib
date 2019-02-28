package com.yq.scommonlib.manager;

import android.app.Activity;
import com.yq.scommonlib.log.SLog;

import java.util.Iterator;
import java.util.Stack;

/**
 * author: Y_Qing
 * date: 2019/2/16
 */
public class ActivityManager {
    private static Stack<Activity> activityStack;

    private static class ActivityHolder {
        private static final ActivityManager manager = new ActivityManager();
    }

    public static ActivityManager getInstance() {
        return ActivityHolder.manager;
    }

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
    }

    public Activity currentActivity() {
        return activityStack.lastElement();
    }

    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    public void finishActivity(Class<?> cls) {
        Iterator var2 = activityStack.iterator();
        Activity activity;
        do {
            if (!var2.hasNext()) {
                return;
            }
            activity = (Activity) var2.next();
        } while (!activity.getClass().equals(cls));

        this.finishActivity(activity);
    }

    public void finishAllActivity() {
        int i = 0;
        for (int size = activityStack.size(); i < size; ++i) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    public void exitApp() {
        SLog.e("ActivityManager", "app exit");
        try {
            this.finishAllActivity();
            Runtime.getRuntime().exit(0);
        } catch (Exception var3) {
            SLog.e("ActivityManager", "app exit" + var3.getMessage());
        }
    }
}
