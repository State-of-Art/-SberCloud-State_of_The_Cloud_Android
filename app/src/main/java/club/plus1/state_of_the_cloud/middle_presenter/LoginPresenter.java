package club.plus1.state_of_the_cloud.middle_presenter;

import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

import club.plus1.state_of_the_cloud.view_activity.DashboardActivity;
import club.plus1.state_of_the_cloud.view_activity.HotLineActivity;
import club.plus1.state_of_the_cloud.view_activity.LoginActivity;
import club.plus1.state_of_the_cloud.view_activity.RecoveryActivity;
import club.plus1.state_of_the_cloud.view_activity.RegisterActivity;
import club.plus1.state_of_the_cloud.view_tools.ActivityTools;

public class LoginPresenter {

    private final LoginActivity context;

    public LoginPresenter(LoginActivity context) {
        this.context = context;
    }

    public void onStart(Bundle bundle) {
        if (bundle != null) {
            context.showSnackBar(bundle.getString("message"));
        }
    }

    public void enter(String domain, String login, String password) {
        Map<String, Object> extra = new HashMap<>();
        extra.put("domain", domain);
        extra.put("login", login);
        extra.put("password", password);
        ActivityTools.openActivity(context, DashboardActivity.class, extra);
    }

    public void hotLine() {
        ActivityTools.openActivity(context, HotLineActivity.class);
    }

    public void register() {
        ActivityTools.openActivity(context, RegisterActivity.class);
    }

    public void recovery(String domain, String login) {
        Map<String, Object> extra = new HashMap<>();
        extra.put("domain", domain);
        extra.put("login", login);
        ActivityTools.openActivity(context, RecoveryActivity.class, extra);
    }
}
