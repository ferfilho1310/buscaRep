package com.example.buscarep.Daos;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.buscarep.Activity.MainActivity;
import com.example.buscarep.DialogHelpers.AbstratcAlertDialog;
import com.example.buscarep.Enums.SharedEnums;
import com.example.buscarep.Interfaces.IUserDao;
import com.example.buscarep.Model.Usuario;
import com.example.buscarep.Util.GetViewData;
import com.example.buscarep.Util.IntentHelper;
import com.example.buscarep.Util.MensagemSistema;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class UserDao implements IUserDao {

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    CollectionReference db_users = FirebaseFirestore.getInstance().collection("Users");

    @Override
    public void entrarUser(Usuario usuario, final Activity activity, final ProgressBar progressBar, final Button button, final TextView textView) {

        progressBar.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);

        firebaseAuth.signInWithEmailAndPassword(usuario.getmEmail(), usuario.getmSenha())
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.VISIBLE);
                            button.setVisibility(View.GONE);
                            textView.setVisibility(View.GONE);
                            IntentHelper.getInstance().IntentWithFinish(activity, MainActivity.class);
                        } else {
                            progressBar.setVisibility(View.GONE);
                            button.setVisibility(View.VISIBLE);
                            textView.setVisibility(View.VISIBLE);
                            AbstratcAlertDialog.getInstance().mShowInfo(activity, MensagemSistema.ERRO_ENTRAR);
                        }
                    }
                }).addOnFailureListener(activity, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i(MensagemSistema.TAG, "Erro ao entrar" + e);
            }
        });
    }

    @Override
    public void cadastrarUser(final Usuario usuario, final Activity activity, final ProgressBar progressBar, final Button button) {

        progressBar.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
        firebaseAuth.createUserWithEmailAndPassword(usuario.getmEmail(), usuario.getmSenha()).addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Map<String, String> map = new HashMap<>();

                    map.put("Nome", usuario.getmNome());
                    map.put("E-mail", usuario.getmEmail());
                    map.put("Senha", usuario.getmSenha());
                    map.put("Confirmar Senha", usuario.getmConfirmaSenha());

                    db_users.add(map);
                    progressBar.setVisibility(View.GONE);
                    button.setVisibility(View.VISIBLE);

                    IntentHelper.getInstance().IntentWithFinishAndFlags(activity, MainActivity.class);

                } else if (!task.isSuccessful()) {
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthWeakPasswordException e) {
                        Toast.makeText(activity, "Senha inferior a 6 caracteres", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        Toast.makeText(activity, "E-mail inválido", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    } catch (FirebaseAuthUserCollisionException e) {
                        Toast.makeText(activity, "Usuário já cadastrado", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    } catch (Exception e) {
                        Toast.makeText(activity, "Ops!Erro a cadastrar o usuário", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
            }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i(MensagemSistema.TAG, "Erro desconhecido" + e);
            }
        });
    }

}
