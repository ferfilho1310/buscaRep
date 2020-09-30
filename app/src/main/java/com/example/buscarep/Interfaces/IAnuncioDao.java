package com.example.buscarep.Interfaces;

import com.example.buscarep.mvc.Model.Anuncio;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public interface IAnuncioDao {

    FirestoreRecyclerOptions<Anuncio> buscaAnuncios();

    void cadastraAnuncios();

}
