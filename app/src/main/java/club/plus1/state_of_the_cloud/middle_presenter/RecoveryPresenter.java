package club.plus1.state_of_the_cloud.middle_presenter;

import java.util.HashMap;
import java.util.Map;

import club.plus1.state_of_the_cloud.R;
import club.plus1.state_of_the_cloud.view_activity.LoginActivity;
import club.plus1.state_of_the_cloud.view_activity.RecoveryActivity;
import club.plus1.state_of_the_cloud.view_tools.ActivityTools;

public class RecoveryPresenter {

    private final RecoveryActivity context;

    public RecoveryPresenter(RecoveryActivity context) {
        this.context = context;
    }

    public void sendCode(String emailPhone) {
        if (emailPhone != null && !emailPhone.isEmpty()) {
            context.secondStep(true);
            context.thirdStep(false);
        }
    }

    public void checkCode(String code) {
        if (code != null && !code.isEmpty()) {
            context.thirdStep(true);
        }
    }

    public void changePassword(String password, String confirm) {
        if (password != null && confirm != null && !password.isEmpty() && !confirm.isEmpty() && password.equals(confirm)) {
            context.finish();
            Map<String, Object> extra = new HashMap<>();
            extra.put("message", context.getResources().getString(R.string.recovery_password_snack_bar));
            ActivityTools.openActivity(context, LoginActivity.class, extra);
        }
    }
}
