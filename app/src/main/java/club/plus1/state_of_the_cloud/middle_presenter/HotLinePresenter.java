package club.plus1.state_of_the_cloud.middle_presenter;

import java.util.ArrayList;
import java.util.List;

import club.plus1.state_of_the_cloud.R;
import club.plus1.state_of_the_cloud.domain_model.Message;
import club.plus1.state_of_the_cloud.middle_adapter.HotLineAdapter;
import club.plus1.state_of_the_cloud.view_activity.HotLineActivity;

public class HotLinePresenter {

    private final HotLineActivity context;
    private List<Message> list;
    private HotLineAdapter adapter;

    public HotLinePresenter(HotLineActivity context) {
        this.context = context;
    }

    public void onStart() {
        list = new ArrayList<>();
        adapter = new HotLineAdapter(list);
        context.setRecyclerView(adapter);
    }

    public void onAddText(String text) {
        list.add(0, new Message(text, true));
        list.add(0, new Message(context.getResources().getString(R.string.hotline_operators_text), false));
        adapter.notifyDataSetChanged();
        context.afterAddText();
    }
}
