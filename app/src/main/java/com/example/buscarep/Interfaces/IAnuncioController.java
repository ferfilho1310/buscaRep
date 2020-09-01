package com.example.buscarep.Interfaces;

import android.app.Activity;

import com.example.buscarep.Model.Anuncio;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.Query;

public interface IAnuncioController {

    FirestoreRecyclerOptions buscaAnuncios();
}
