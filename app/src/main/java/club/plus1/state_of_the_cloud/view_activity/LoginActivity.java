package club.plus1.state_of_the_cloud.view_activity;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import club.plus1.state_of_the_cloud.R;
import club.plus1.state_of_the_cloud.databinding.ActivityLoginBinding;
import club.plus1.state_of_the_cloud.middle_presenter.LoginPresenter;

public class LoginActivity extends BaseActivity {

    public ActivityLoginBinding binding;
    public LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        binding.hotLineButton.setOnClickListener(v -> presenter.hotLine());
        binding.registerButton.setOnClickListener(v -> presenter.register());
        binding.recoverButton.setOnClickListener(
            v -> presenter.recovery(
                binding.domainEdit.getText().toString(),
                binding.loginEdit.getText().toString()
            )
        );
        binding.enterButton.setOnClickListener(
                v -> presenter.enter(
                        binding.domainEdit.getText().toString(),
                        binding.loginEdit.getText().toString(),
                        binding.passwordEdit.getText().toString()
                )
        );
        setContentView(binding.getRoot());
        presenter = new LoginPresenter(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart(getIntent().getExtras());
    }

    public void showSnackBar(String message) {
        Snackbar.make(binding.rootLayout, message, Snackbar.LENGTH_LONG).show();
    }
}