package com.azkari;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AzkarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<AzkarItem> azkarList;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public AzkarAdapter(ArrayList<AzkarItem> azkarList) {
        this.azkarList = azkarList;
    }

    @Override
    public int getItemViewType(int position) {
        return azkarList.get(position).isHeader ? TYPE_HEADER : TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_azkar_header, parent, false);
            return new HeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_azkar, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AzkarItem item = azkarList.get(position);
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).headerTitle.setText(item.title);
        } else {
            ((ItemViewHolder) holder).azkarTitle.setText(item.title);
            ((ItemViewHolder) holder).azkarText.setText(item.text);
        }
    }

    @Override
    public int getItemCount() {
        return azkarList.size();
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView headerTitle;
        HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            headerTitle = itemView.findViewById(R.id.headerTitle);
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView azkarTitle, azkarText;
        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            azkarTitle = itemView.findViewById(R.id.azkarTitle);
            azkarText = itemView.findViewById(R.id.azkarText);
        }
    }
}
