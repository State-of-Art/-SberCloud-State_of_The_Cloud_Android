package club.plus1.state_of_the_cloud.middle_presenter;

import java.util.HashMap;
import java.util.Map;

import club.plus1.state_of_the_cloud.R;
import club.plus1.state_of_the_cloud.view_activity.LoginActivity;
import club.plus1.state_of_the_cloud.view_activity.RegisterActivity;
import club.plus1.state_of_the_cloud.view_activity.WebActivity;
import club.plus1.state_of_the_cloud.view_tools.ActivityTools;

public class RegisterPresenter {

    private final RegisterActivity context;

    public RegisterPresenter(RegisterActivity context) {
        this.context = context;
    }

    public void onSend() {
        context.finish();
        Map<String, Object> extra = new HashMap<>();
        extra.put("message", context.getResources().getString(R.string.register_send_snack_bar));
        ActivityTools.openActivity(context, LoginActivity.class, extra);
    }

    public void processing() {
        Map<String, Object> extra = new HashMap<>();
        extra.put("url", "https://sbercloud.ru/ru/documents/consent");
        ActivityTools.openActivity(context, WebActivity.class, extra);
    }

    public void confidentiality() {
        Map<String, Object> extra = new HashMap<>();
        extra.put("url", "https://sbercloud.ru/ru/documents/privacy-policy");
        ActivityTools.openActivity(context, WebActivity.class, extra);
    }
}
