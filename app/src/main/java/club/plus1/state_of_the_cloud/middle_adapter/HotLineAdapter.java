package club.plus1.state_of_the_cloud.middle_adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import club.plus1.state_of_the_cloud.databinding.ItemHotLineReceiveBinding;
import club.plus1.state_of_the_cloud.databinding.ItemHotLineSendBinding;
import club.plus1.state_of_the_cloud.domain_model.Message;
import club.plus1.state_of_the_cloud.view_holder.HotLineReceiveViewHolder;
import club.plus1.state_of_the_cloud.view_holder.HotLineSendViewHolder;

public class HotLineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SEND = 1;
    private static final int RECEIVE = 2;

    private final List<Message> list;

    public HotLineAdapter(List<Message> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(final int position) {
        return list.get(position).direction ? SEND : RECEIVE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == SEND) {
            ItemHotLineSendBinding binding = ItemHotLineSendBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new HotLineSendViewHolder(binding);
        } else {
            ItemHotLineReceiveBinding binding = ItemHotLineReceiveBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new HotLineReceiveViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == SEND) {
            ((HotLineSendViewHolder)holder).bind(list.get(position));
        } else {
            ((HotLineReceiveViewHolder)holder).bind(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
