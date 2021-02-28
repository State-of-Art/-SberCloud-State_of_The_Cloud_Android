package club.plus1.state_of_the_cloud.view_activity;

import android.os.Bundle;

import club.plus1.state_of_the_cloud.databinding.ActivityDashboardBinding;
import club.plus1.state_of_the_cloud.middle_presenter.DashboardPresenter;

public class DashboardActivity extends BaseActivity {

    public ActivityDashboardBinding binding;
    public DashboardPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new DashboardPresenter(this);
    }
}