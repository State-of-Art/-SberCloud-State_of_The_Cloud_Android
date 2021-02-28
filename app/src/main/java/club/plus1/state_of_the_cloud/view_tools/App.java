package club.plus1.state_of_the_cloud.view_tools;

import android.app.Application;

public class App extends Application {

    public static Application context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
