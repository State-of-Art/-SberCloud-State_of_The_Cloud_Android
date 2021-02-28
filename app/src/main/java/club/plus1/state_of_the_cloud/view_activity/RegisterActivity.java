package club.plus1.state_of_the_cloud.view_activity;

import android.os.Bundle;

import club.plus1.state_of_the_cloud.databinding.ActivityRegisterBinding;
import club.plus1.state_of_the_cloud.middle_presenter.RegisterPresenter;

public class RegisterActivity extends BaseActivity {

    public ActivityRegisterBinding binding;
    public RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        binding.sendButton.setOnClickListener(v -> presenter.onSend());
        binding.processingLink.setOnClickListener(v -> presenter.processing());
        binding.confidentialityLink.setOnClickListener(v -> presenter.confidentiality());
        setContentView(binding.getRoot());
        presenter = new RegisterPresenter(this);
    }
}