package com.naufal.testadprieds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.naufal.testadprieds.adapter.ApprovalDocumentAdapter;
import com.naufal.testadprieds.databinding.ActivityMainBinding;
import com.naufal.testadprieds.model.ApprovalDocument;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ApprovalDocumentAdapter.ApprovalDocumentListener {

    ApprovalDocumentAdapter adapter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ApprovalDocumentAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter.addListener(this::onClick);
        binding.listApproval.setHasFixedSize(true);
        binding.listApproval.setLayoutManager(layoutManager);
        binding.listApproval.setAdapter(adapter);

        ArrayList<ApprovalDocument> approvals = new ArrayList<>();
        approvals.add(new ApprovalDocument("Document 1", "Approval 1"));
        approvals.add(new ApprovalDocument("Document 2", "Approval 2"));
        approvals.add(new ApprovalDocument("Document 3", "Approval 3"));

        adapter.setData(approvals);
    }

    @Override
    public void onClick(ApprovalDocument data) {
        startActivity(new Intent(this, DocumentApprovalListActivity.class));
    }
}