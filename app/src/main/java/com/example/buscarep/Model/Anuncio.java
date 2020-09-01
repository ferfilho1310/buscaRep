package com.example.buscarep.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Anuncio implements Parcelable {

    private List<String> fotos = new ArrayList<>();
    private String descricao;
    private String aluguel;
    private String contato;

    public Anuncio() {
    }

    protected Anuncio(Parcel in) {
        fotos = in.createStringArrayList();
        descricao = in.readString();
        aluguel = in.readString();
        contato = in.readString();
    }

    public static final Creator<Anuncio> CREATOR = new Creator<Anuncio>() {
        @Override
        public Anuncio createFromParcel(Parcel in) {
            return new Anuncio(in);
        }

        @Override
        public Anuncio[] newArray(int size) {
            return new Anuncio[size];
        }
    };

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAluguel() {
        return aluguel;
    }

    public void setAluguel(String aluguel) {
        this.aluguel = aluguel;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "fotos=" + fotos +
                ", descricao='" + descricao + '\'' +
                ", aluguel='" + aluguel + '\'' +
                ", contato='" + contato + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(fotos);
        dest.writeString(descricao);
        dest.writeString(aluguel);
        dest.writeString(contato);
    }
}
