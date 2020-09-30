package com.example.buscarep.mvc.Controllers;

import com.example.buscarep.Daos.AnuncioDao;
import com.example.buscarep.Interfaces.IAnuncioController;
import com.example.buscarep.Interfaces.IAnuncioDao;
import com.example.buscarep.mvc.Model.Anuncio;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class AnuncioController implements IAnuncioController {

    private static AnuncioController anuncioController;
    private static IAnuncioDao iAnuncioDao;

    public static synchronized AnuncioController getInstance() {
        anuncioController = new AnuncioController();
        iAnuncioDao = new AnuncioDao();
        return anuncioController;
    }

    @Override
    public FirestoreRecyclerOptions<Anuncio> buscaAnuncios() {
        return iAnuncioDao.buscaAnuncios();
    }
}
