package com.naufal.testadprieds.model;

public class ListDocumentApproval {

    String date;
    boolean remark;
    String no_document;
    String document_name;
    String requester;
    String site;
    String status;
    String days;

    public ListDocumentApproval(String date, boolean remark, String no_document, String document_name, String requester, String site, String status, String days) {
        this.date = date;
        this.remark = remark;
        this.no_document = no_document;
        this.document_name = document_name;
        this.requester = requester;
        this.site = site;
        this.status = status;
        this.days = days;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isRemark() {
        return remark;
    }

    public void setRemark(boolean remark) {
        this.remark = remark;
    }

    public String getNo_document() {
        return no_document;
    }

    public void setNo_document(String no_document) {
        this.no_document = no_document;
    }

    public String getDocument_name() {
        return document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
