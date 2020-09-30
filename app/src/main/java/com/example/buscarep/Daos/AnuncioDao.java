package com.example.buscarep.Daos;

import com.example.buscarep.Enums.SharedEnums;
import com.example.buscarep.Interfaces.IAnuncioDao;
import com.example.buscarep.mvc.Model.Anuncio;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AnuncioDao implements IAnuncioDao {

    FirebaseAuth usersId = FirebaseAuth.getInstance();

    FirebaseFirestore abriBancoAnuncios = FirebaseFirestore.getInstance();
    CollectionReference collectionAnuncios = abriBancoAnuncios.collection("Anuncios")
            .document("teste")
            .collection("anunciosPorCliente");
    FirestoreRecyclerOptions<Anuncio> firestoreRecyclerOptions;
    Query query;

    private static AnuncioDao anuncioDao;

    public static synchronized AnuncioDao getInstance() {
        anuncioDao = new AnuncioDao();
        return anuncioDao;
    }

    @Override
    public FirestoreRecyclerOptions<Anuncio> buscaAnuncios() {
        query = collectionAnuncios.orderBy(SharedEnums.ordenacaoDb.ordenacaoDbBuscaAnuncio, Query.Direction.ASCENDING);
        firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Anuncio>()
                .setQuery(query, Anuncio.class)
                .build();
        return firestoreRecyclerOptions;
    }

    @Override
    public void cadastraAnuncios() {

    }
}
