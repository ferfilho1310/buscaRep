package com.example.buscarep.Controllers;

import com.example.buscarep.Daos.AnuncioDao;
import com.example.buscarep.Interfaces.IAnuncioController;
import com.example.buscarep.Model.Anuncio;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class AnuncioController implements IAnuncioController {

    private static AnuncioController anuncioController;

    public static synchronized  AnuncioController getInstance(){
        anuncioController = new AnuncioController();
        return anuncioController;
    }

    @Override
    public FirestoreRecyclerOptions<Anuncio> buscaAnuncios() {
        return AnuncioDao.getInstance().buscaAnuncios();
    }
}
