package com.aidazi.scommonlib.manager;

import android.app.Activity;

import com.aidazi.scommonlib.log.SLog;

import java.util.Iterator;
import java.util.Stack;


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


    public void removeActivity(Activity activity) {
        if (activityStack == null || activityStack.size() == 0) {
            return;
        }
        if (activity != null) {
            activityStack.remove(activity);
        }
    }

    public void finishActivity(Class<?> cls) {
        if (activityStack == null || activityStack.size() == 0) {
            return;
        }
        Iterator var2 = activityStack.iterator();
        Activity activity;
        do {
            if (!var2.hasNext()) {
                return;
            }
            activity = (Activity) var2.next();
        } while (!activity.getClass().equals(cls));
        activity.finish();
    }

    public void finishAllActivity() {
        if (activityStack == null || activityStack.size() == 0) {
            return;
        }
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
