package com.naufal.testadprieds.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.naufal.testadprieds.R;
import com.naufal.testadprieds.databinding.ApprovalDocumentItemLayoutBinding;
import com.naufal.testadprieds.databinding.CartListItemLayoutBinding;
import com.naufal.testadprieds.model.ApprovalDocument;
import com.naufal.testadprieds.model.CartList;

import java.util.List;

public class CartListAdapter extends BaseRecycleViewAdapter<CartList, CartListAdapter.ViewHolder>{
    CartListListener listener;
    private List<CartList> originalData;
    Context context;

    public CartListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_item_layout, parent, false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends BaseRecycleViewAdapter.ViewHolder {
        CartListItemLayoutBinding binding;

        public ViewHolder(View view) {
            super(view);
            binding = CartListItemLayoutBinding.bind(view);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CartList item = getItem(position);
        holder.item = item;

        item.setExpanded(false);

        if (item.isExpanded()) {
            //expand
            holder.binding.sectionHide.setVisibility(View.VISIBLE);

        } else {
            //colapse
            holder.binding.sectionHide.setVisibility(View.GONE);

        }

        holder.itemView.setOnClickListener(view -> {
            if (item.isExpanded()){
                holder.binding.sectionHide.setVisibility(View.GONE);
                item.setExpanded(false);
            }else{
                holder.binding.sectionHide.setVisibility(View.VISIBLE);
                item.setExpanded(true);
            }
        });

    }

    @Override
    public void setData(List<CartList> list) {
        this.originalData = list;
        super.setData(list);
    }

    public List<CartList> getDataOriginal() {
        return this.originalData;
    }

    public void addListener(CartListListener listener) {
        this.listener = listener;
    }

    public interface CartListListener {
        void onClick(CartList data);
    }
}
