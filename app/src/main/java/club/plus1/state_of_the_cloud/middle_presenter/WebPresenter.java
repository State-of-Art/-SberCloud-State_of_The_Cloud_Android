package club.plus1.state_of_the_cloud.middle_presenter;

import android.os.Bundle;

import club.plus1.state_of_the_cloud.view_activity.WebActivity;

public class WebPresenter {

    public final WebActivity context;

    public WebPresenter(WebActivity context) {
        this.context = context;
    }

    public void onStart(Bundle bundle) {
        if (bundle != null) {
            context.loadUrl(bundle.getString("url"));
        }
    }
}
