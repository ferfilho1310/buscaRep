package com.example.buscarep.DialogHelpers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.buscarep.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ButtomSheetDialogEmailVazio extends BottomSheetDialogFragment {

    private static ButtomSheetDialogEmailVazio buttomSheetDialogEmailSenhaVazio;

    public static synchronized ButtomSheetDialogEmailVazio getInstance() {
        buttomSheetDialogEmailSenhaVazio = new ButtomSheetDialogEmailVazio();
        return buttomSheetDialogEmailSenhaVazio;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.buttom_sheet_layout_email_vazio, container, false);
        Button btn_ok = view.findViewById(R.id.bsl_btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }

}
