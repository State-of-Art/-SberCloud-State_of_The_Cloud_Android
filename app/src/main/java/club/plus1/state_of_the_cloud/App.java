package club.plus1.state_of_the_cloud;

import android.app.Application;

public class App extends Application {

    public static Application context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
