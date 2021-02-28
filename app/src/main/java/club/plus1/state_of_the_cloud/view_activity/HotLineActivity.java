package club.plus1.state_of_the_cloud.view_activity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import club.plus1.state_of_the_cloud.databinding.ActivityHotLineBinding;
import club.plus1.state_of_the_cloud.middle_adapter.HotLineAdapter;
import club.plus1.state_of_the_cloud.middle_presenter.HotLinePresenter;

public class HotLineActivity extends BaseActivity {

    public ActivityHotLineBinding binding;
    public HotLinePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHotLineBinding.inflate(getLayoutInflater());
        binding.hotlineButton.setOnClickListener(v ->
            presenter.onAddText(binding.hotlineText.getText().toString())
        );
        setContentView(binding.getRoot());
        presenter = new HotLinePresenter(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    public void setRecyclerView(HotLineAdapter adapter) {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        manager.setStackFromEnd(true);
        manager.setReverseLayout(true);
        binding.hotlineList.setLayoutManager(manager);
        binding.hotlineList.setAdapter(adapter);
    }

    public void afterAddText(){
        binding.hotlineList.scrollToPosition(0);
        binding.hotlineText.setText("");
    }
}