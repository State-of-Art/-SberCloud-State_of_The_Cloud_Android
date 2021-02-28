package club.plus1.state_of_the_cloud.view_tools;

import android.content.Intent;

import androidx.annotation.Nullable;

import java.util.Map;

import club.plus1.state_of_the_cloud.view_activity.BaseActivity;

public class ActivityTools {

    public static void openActivity(BaseActivity context, Class<?> activityClass) {
        openActivity(context, activityClass, null, null);
    }

    public static void openActivity(BaseActivity context, Class<?> activityClass, @Nullable Map<String, ?> extra) {
        openActivity(context, activityClass, extra, null);
    }

    public static void openActivity(BaseActivity context, Class<?> activityClass,
                                @Nullable Map<String, ?> extra, @Nullable Integer requestCode) {
        Intent intent = new Intent(context, activityClass);
        if (extra != null && extra.size() > 0) {
            for (Map.Entry<String, ?> entry: extra.entrySet()) {
                if (entry.getValue() instanceof Integer){
                    intent.putExtra(entry.getKey(), (Integer) entry.getValue());
                } else if (entry.getValue() instanceof String) {
                    intent.putExtra(entry.getKey(), (String) entry.getValue());
                } else if (entry.getValue() instanceof Boolean) {
                    intent.putExtra(entry.getKey(), (Boolean) entry.getValue());
                } else if (entry.getValue() instanceof Float) {
                    intent.putExtra(entry.getKey(), (Float) entry.getValue());
                }
            }
        }
        if (requestCode != null && requestCode > 0) {
            context.startActivityForResult(intent, requestCode);
        } else {
            context.startActivity(intent);
        }
    }
}
