package com.naufal.testadprieds;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.naufal.testadprieds.adapter.CartListAdapter;
import com.naufal.testadprieds.adapter.ListApprovalDocumentAdapter;
import com.naufal.testadprieds.databinding.FragmentDetailDocumentsBottomSheetBinding;
import com.naufal.testadprieds.model.CartList;
import com.naufal.testadprieds.model.ListDocumentApproval;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailDocumentsBottomSheet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailDocumentsBottomSheet extends BottomSheetDialogFragment {

    FragmentDetailDocumentsBottomSheetBinding binding;
    CartListAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailDocumentsBottomSheet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailDocumentsBottomSheet.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailDocumentsBottomSheet newInstance(String param1, String param2) {
        DetailDocumentsBottomSheet fragment = new DetailDocumentsBottomSheet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetailDocumentsBottomSheetBinding.inflate(inflater);

        adapter = new CartListAdapter(getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        adapter.addListener(this);
        binding.listCart.setHasFixedSize(true);
        binding.listCart.setLayoutManager(layoutManager);
        binding.listCart.setAdapter(adapter);

        ArrayList<CartList> carts = new ArrayList<>();
        carts.add(new CartList("2220 WRG KEMASAN DRUM @ 200 KG WIP", "210000430", "12/7/21, 11:40 AM", "4", "", "Rp22,555.00", "Rp45,110.00", "", false));
        carts.add(new CartList("AMPLAS BT BTEX P0000 M 18 NB 150MMX230MM - BROWN", "210000430", "12/7/21, 11:40 AM", "4", "", "Rp22,555.00", "Rp45,110.00", "", false));

        adapter.setData(carts);

        return binding.getRoot();
    }

    void closeBottom(){
        dismiss();
    }
}