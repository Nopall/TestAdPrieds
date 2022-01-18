package com.naufal.testadprieds.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.naufal.testadprieds.R;
import com.naufal.testadprieds.databinding.ApprovalDocumentItemLayoutBinding;
import com.naufal.testadprieds.model.ApprovalDocument;

import java.util.ArrayList;
import java.util.List;

public class ApprovalDocumentAdapter extends BaseRecycleViewAdapter<ApprovalDocument, ApprovalDocumentAdapter.ViewHolder>{
    ApprovalDocumentListener listener;
    private List<ApprovalDocument> originalData;
    Context context;

    public ApprovalDocumentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.approval_document_item_layout, parent, false);

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
        ApprovalDocument item = getItem(position);
        holder.item = item;

        holder.binding.txtApproval.setText(item.getApproval());
        holder.binding.txtDocument.setText(item.getDocuments());

        holder.binding.btnDetail.setOnClickListener(view -> {
            listener.onClick(item);
        });

    }

    @Override
    public void setData(List<ApprovalDocument> list) {
        this.originalData = list;
        super.setData(list);
    }

    public List<ApprovalDocument> getDataOriginal() {
        return this.originalData;
    }

    public void addListener(ApprovalDocumentListener listener) {
        this.listener = listener;
    }

    public interface ApprovalDocumentListener {
        void onClick(ApprovalDocument data);
    }
}
