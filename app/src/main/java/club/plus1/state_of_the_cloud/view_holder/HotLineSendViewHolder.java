package club.plus1.state_of_the_cloud.view_holder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import club.plus1.state_of_the_cloud.databinding.ItemHotLineSendBinding;
import club.plus1.state_of_the_cloud.domain_model.Message;

public class HotLineSendViewHolder extends RecyclerView.ViewHolder {

    private final ItemHotLineSendBinding binding;

    public HotLineSendViewHolder(@NonNull ItemHotLineSendBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Message message) {
        binding.itemText.setText(message.text);
    }
}
