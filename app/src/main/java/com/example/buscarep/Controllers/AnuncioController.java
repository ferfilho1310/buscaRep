package com.example.buscarep.Controllers;

import com.example.buscarep.Daos.AnuncioDao;
import com.example.buscarep.Daos.UserDao;
import com.example.buscarep.Interfaces.IAnuncioController;
import com.example.buscarep.Interfaces.IAnuncioDao;
import com.example.buscarep.Model.Anuncio;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.Query;

public class AnuncioController implements IAnuncioController {

    private static AnuncioController anuncioController;
    private static IAnuncioDao iAnuncioDao;

    public static synchronized  AnuncioController getInstance(){
        if(anuncioController == null){
            anuncioController = new AnuncioController();
            iAnuncioDao = new AnuncioDao();
        }
        return anuncioController;
    }

    @Override
    public FirestoreRecyclerOptions<Anuncio> buscaAnuncios() {
        return iAnuncioDao.buscaAnuncios();
    }
}
