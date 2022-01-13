package com.naufal.testadprieds.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.naufal.testadprieds.R;
import com.naufal.testadprieds.databinding.ApprovalDocumentItemLayoutBinding;
import com.naufal.testadprieds.model.ApprovalDocument;
import com.naufal.testadprieds.model.ListDocumentApproval;

import java.util.List;

public class ListApprovalDocumentAdapter extends BaseRecycleViewAdapter<ListDocumentApproval, ListApprovalDocumentAdapter.ViewHolder>{
    ListApprovalDocumentListener listener;
    private List<ListDocumentApproval> originalData;
    Context context;

    public ListApprovalDocumentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.document_approval_list_item_layout, parent, false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends BaseRecycleViewAdapter.ViewHolder {
        ApprovalDocumentItemLayoutBinding binding;

        public ViewHolder(View view) {
            super(view);
            binding = ApprovalDocumentItemLayoutBinding.bind(view);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListDocumentApproval item = getItem(position);
        holder.item = item;


    }

    @Override
    public void setData(List<ListDocumentApproval> list) {
        this.originalData = list;
        super.setData(list);
    }

    public List<ListDocumentApproval> getDataOriginal() {
        return this.originalData;
    }

    public void addListener(ListApprovalDocumentListener listener) {
        this.listener = listener;
    }

    public interface ListApprovalDocumentListener {
        void onDetails(ListDocumentApproval data);
        void onApproved(ListDocumentApproval data);
        void onReject(ListDocumentApproval data);
    }
}
