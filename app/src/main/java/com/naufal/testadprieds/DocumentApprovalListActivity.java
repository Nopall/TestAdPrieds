package com.naufal.testadprieds;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.naufal.testadprieds.adapter.ApprovalDocumentAdapter;
import com.naufal.testadprieds.adapter.ListApprovalDocumentAdapter;
import com.naufal.testadprieds.databinding.ActiivtyDocumentApprovalListBinding;
import com.naufal.testadprieds.databinding.ActivityMainBinding;
import com.naufal.testadprieds.fragment.ConfirmDialog;
import com.naufal.testadprieds.model.ApprovalDocument;
import com.naufal.testadprieds.model.ListDocumentApproval;

import java.util.ArrayList;

public class DocumentApprovalListActivity extends AppCompatActivity implements ListApprovalDocumentAdapter.ListApprovalDocumentListener {

    ActiivtyDocumentApprovalListBinding binding;
    ListApprovalDocumentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiivty_document_approval_list);
        binding = ActiivtyDocumentApprovalListBinding.inflate(getLayoutInflater());

        adapter = new ListApprovalDocumentAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter.addListener(this);
        binding.listApproval.setHasFixedSize(true);
        binding.listApproval.setLayoutManager(layoutManager);
        binding.listApproval.setAdapter(adapter);

        ArrayList<ListDocumentApproval> approvals = new ArrayList<>();
        approvals.add(new ListDocumentApproval("12/7/21, 11:40 AM", true, "MTU-211122", "Material Usage", "ayesbenedit", "BENEDIT", "Waiting for Approval", "15 Days"));
        approvals.add(new ListDocumentApproval("12/7/21, 11:40 AM", true, "MTU-211122", "Material Usage", "ayesbenedit", "BENEDIT", "Waiting for Approval", "15 Days"));
    }

    @Override
    public void onDetails(ListDocumentApproval data) {
        DetailDocumentsBottomSheet bottomSheet = new DetailDocumentsBottomSheet();
        bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");
    }

    @Override
    public void onApproved(ListDocumentApproval data) {
        ConfirmDialog cdd=new ConfirmDialog(DocumentApprovalListActivity.this);
        cdd.show();
    }

    @Override
    public void onReject(ListDocumentApproval data) {
        ConfirmDialog cdd=new ConfirmDialog(DocumentApprovalListActivity.this);
        cdd.show();
    }
}