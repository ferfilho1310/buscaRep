package com.example.buscarep.mvc.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.buscarep.mvc.Controllers.UserController;
import com.example.buscarep.mvc.Model.Usuario;
import com.example.buscarep.R;

public class CadastrarActView extends AppCompatActivity implements View.OnClickListener {

    private Button btn_cadastrar_user;
    private EditText edt_email_cadastro;
    private EditText edt_senha_cadastro;
    private EditText edt_nome;
    private EditText edt_confirma_senha;
    private ProgressBar prg_cadastrar_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_act_view);

        getSupportActionBar().hide();

        edt_nome = findViewById(R.id.edt_nome);
        edt_senha_cadastro = findViewById(R.id.edt_senha_cadastro);
        edt_confirma_senha = findViewById(R.id.edt_confirma_senha);
        edt_email_cadastro = findViewById(R.id.edt_email_cadastro);

        btn_cadastrar_user = findViewById(R.id.btn_cadastrar_user);
        prg_cadastrar_user = findViewById(R.id.prg_cadastrar_user);

        btn_cadastrar_user.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cadastrar_user:
                dadosUsario();
                break;
        }
    }

    private void dadosUsario() {
        Usuario usuario = new Usuario();
        usuario.setmNome(edt_nome.getText().toString());
        usuario.setmSenha(edt_senha_cadastro.getText().toString());
        usuario.setmConfirmaSenha(edt_confirma_senha.getText().toString());
        usuario.setmEmail(edt_email_cadastro.getText().toString());
        if (usuario.toString().isEmpty()) {

        } else if (usuario.mEmailVazio()) {

        } else if (usuario.mNomeVazio()) {

        } else if (usuario.mConfirmaSenhaVazio()) {

        } else if (usuario.mSenhaVazio()) {

        } else {
            UserController.getInstance().mCadastrarUser(usuario, CadastrarActView.this, prg_cadastrar_user, btn_cadastrar_user);
        }
    }
}