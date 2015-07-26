package mslbrowser.bizcalc.pl.parallaxcardview;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ItemModel> items = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public MyCardView myCardView;

        public ViewHolder(View view) {
            super(view);
            myCardView = (MyCardView) view.findViewById(R.id.my_card_view);

        }

    }

    public void setData(List<ItemModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemModel item = items.get(position);

        MyCardView myCardView = holder.myCardView;
        myCardView.setTitle(item.title);
        myCardView.setImage(item.imageUri);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}


