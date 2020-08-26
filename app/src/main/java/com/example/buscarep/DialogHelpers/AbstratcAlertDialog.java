package com.example.buscarep.DialogHelpers;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.buscarep.Util.MensagemSistema;

public class AbstratcAlertDialog {

    private static AbstratcAlertDialog abstratcAlertDialog;

    public static synchronized AbstratcAlertDialog getInstance() {
        abstratcAlertDialog = new AbstratcAlertDialog();
        return abstratcAlertDialog;
    }

    public void mShowInfo(Context context, String message) {
        new AlertDialog.Builder(context)
                .setTitle(MensagemSistema.TITLE_ATENCAO)
                .setMessage(message)
                .setNegativeButton(MensagemSistema.BUTTON_DIALOG_OK, null)
                .show();

    }

}
