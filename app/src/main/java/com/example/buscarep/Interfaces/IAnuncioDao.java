package com.example.buscarep.Interfaces;

import com.example.buscarep.Model.Anuncio;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public interface IAnuncioDao {

    FirestoreRecyclerOptions buscaAnuncios();

    void cadastraAnuncios();

}
