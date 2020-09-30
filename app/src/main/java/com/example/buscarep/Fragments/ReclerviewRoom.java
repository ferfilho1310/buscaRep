package com.example.buscarep.Fragments;


import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buscarep.mvc.Model.Anuncio;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ReclerviewRoom extends FirestoreRecyclerAdapter<Anuncio, ReclerviewRoom.ReclerviewRoomViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ReclerviewRoom(@NonNull FirestoreRecyclerOptions<Anuncio> options) {
        super(options);
    }

    @NonNull
    @Override
    public ReclerviewRoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    protected void onBindViewHolder(@NonNull ReclerviewRoomViewHolder holder, int position, @NonNull Anuncio model) {

    }

    public static class ReclerviewRoomViewHolder extends RecyclerView.ViewHolder{

        public ReclerviewRoomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
