package club.plus1.state_of_the_cloud.view_activity;

import android.os.Bundle;
import android.view.View;

import club.plus1.state_of_the_cloud.databinding.ActivityRecoveryBinding;
import club.plus1.state_of_the_cloud.middle_presenter.RecoveryPresenter;

public class RecoveryActivity extends BaseActivity {

    public ActivityRecoveryBinding binding;
    public RecoveryPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecoveryBinding.inflate(getLayoutInflater());
        binding.getCodeButton.setOnClickListener(
            v -> presenter.sendCode(binding.emailPhoneEdit.getText().toString())
        );
        binding.checkCodeButton.setOnClickListener(
            v -> presenter.checkCode(binding.recoveryCodeEdit.getText().toString())
        );
        binding.changePasswordButton.setOnClickListener(
            v -> presenter.changePassword(
                binding.passwordEdit.getText().toString(),
                binding.confirmEdit.getText().toString()
            )
        );
        setContentView(binding.getRoot());
        presenter = new RecoveryPresenter(this);
    }

    public void secondStep(boolean show) {
        if (show) {
            binding.secondStepRecoveryLayout.setVisibility(View.VISIBLE);
        } else {
            binding.secondStepRecoveryLayout.setVisibility(View.GONE);
        }
        binding.recoveryCodeEdit.setText("");
    }

    public void thirdStep(boolean show) {
        if (show) {
            binding.thirdStepRecoveryLayout.setVisibility(View.VISIBLE);
        } else {
            binding.thirdStepRecoveryLayout.setVisibility(View.GONE);
        }
        binding.passwordEdit.setText("");
        binding.confirmEdit.setText("");
    }
}