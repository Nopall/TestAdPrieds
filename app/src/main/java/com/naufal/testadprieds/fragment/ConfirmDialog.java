package com.naufal.testadprieds.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;

import com.naufal.testadprieds.R;
import com.naufal.testadprieds.databinding.DialogConfirmBinding;

public class ConfirmDialog extends Dialog {
    public Activity c;
    public Dialog d;
    DialogConfirmBinding binding;

    public ConfirmDialog(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_confirm);
        binding = DialogConfirmBinding.inflate(getLayoutInflater());

        binding.btnNo.setOnClickListener(view -> {
            d.dismiss();
        });

        binding.btnYes.setOnClickListener(view -> {
            d.dismiss();
        });


    }

}
