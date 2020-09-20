package com.example.buscarep.Model;

public class Usuario {

    private String mNome;
    private String mEmail;
    private String mSenha;
    private String mConfirmaSenha;

    public Usuario() {
    }

    public String getmNome() {
        return mNome;
    }

    public void setmNome(String mNome) {
        this.mNome = mNome;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmSenha() {
        return mSenha;
    }

    public void setmSenha(String mSenha) {
        this.mSenha = mSenha;
    }

    public String getmConfirmaSenha() {
        return mConfirmaSenha;
    }

    public void setmConfirmaSenha(String mConfirmaSenha) {
        this.mConfirmaSenha = mConfirmaSenha;
    }

    public boolean mEmailVazio(){
        boolean resultado = false;
        if(getmEmail().isEmpty()){
             resultado = true;
        }
       return resultado;
    }

    public boolean mSenhaVazio(){
        boolean resultado = false;
        if(getmSenha().isEmpty()){
            resultado = true;
        }
        return resultado;
    }

    public boolean mConfirmaSenhaVazio(){
        boolean resultado = false;
        if(getmConfirmaSenha().isEmpty()){
            resultado = true;
        }
        return resultado;
    }

    public boolean mNomeVazio(){
        boolean resultado = false;
        if(getmNome().isEmpty()){
            resultado = true;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "mNome='" + mNome + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mSenha='" + mSenha + '\'' +
                ", mConfirmaSenha='" + mConfirmaSenha + '\'' +
                '}';
    }
}
