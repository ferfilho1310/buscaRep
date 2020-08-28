package com.example.buscarep.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.buscarep.Controllers.EntrarController;
import com.example.buscarep.DialogHelpers.AbstratcAlertDialog;
import com.example.buscarep.DialogHelpers.ButtomSheetDialog;
import com.example.buscarep.Model.Usuario;
import com.example.buscarep.R;
import com.example.buscarep.Util.MensagemSistema;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;

public class EntrarActView extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText edt_email;
    private TextInputEditText edt_senha;
    private TextView txt_cadastrar;

    private Button btn_entrar;
    private ProgressBar pgEntrar;

    ButtomSheetDialog buttomSheetDialog;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        edt_email = findViewById(R.id.edt_email);
        edt_senha = findViewById(R.id.edt_senha);
        btn_entrar = findViewById(R.id.btn_entrar);
        pgEntrar = findViewById(R.id.prb_entrar);
        txt_cadastrar = findViewById(R.id.txt_cadastrar);

        txt_cadastrar.setOnClickListener(this);
        btn_entrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_entrar:
                Usuario usuario = new Usuario();

                usuario.setmEmail(edt_email.getText().toString());
                usuario.setmSenha(edt_senha.getText().toString());

                mValidacaoEmailSenha(usuario);
                break;
            case R.id.txt_cadastrar:
                break;
        }
    }

    public void  mValidacaoEmailSenha(Usuario usuario){
        if(usuario.mEmailVazio() && usuario.mSenhaVazio()){
            ButtomSheetDialog.getInstance().show(getSupportFragmentManager(), MensagemSistema.TAG);
        } else if(usuario.mEmailVazio()){
            edt_email.requestFocus();
            AbstratcAlertDialog.getInstance().mShowInfo(EntrarActView.this,"Informe seu E-mail");
        } else if(usuario.mSenhaVazio()){
            edt_senha.requestFocus();
            AbstratcAlertDialog.getInstance().mShowInfo(EntrarActView.this,"Informe sua senha");
        } else {
            EntrarController.getInstance().mEntrar(usuario, EntrarActView.this, pgEntrar,btn_entrar);
        }
    }
}