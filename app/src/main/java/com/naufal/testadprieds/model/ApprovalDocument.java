package com.naufal.testadprieds.model;

public class ApprovalDocument {
    
    String documents;
    String approval;

    public ApprovalDocument(String documents, String approval) {
        this.documents = documents;
        this.approval = approval;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }
}
