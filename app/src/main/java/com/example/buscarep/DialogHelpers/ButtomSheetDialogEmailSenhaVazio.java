package com.example.buscarep.DialogHelpers;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.buscarep.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ButtomSheetDialogEmailSenhaVazio extends BottomSheetDialogFragment {

    private static ButtomSheetDialogEmailSenhaVazio buttomSheetDialogEmailSenhaVazio;

    public static synchronized ButtomSheetDialogEmailSenhaVazio getInstance() {
        buttomSheetDialogEmailSenhaVazio = new ButtomSheetDialogEmailSenhaVazio();
        return buttomSheetDialogEmailSenhaVazio;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.buttom_sheet_layout, container, false);
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
