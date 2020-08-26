package com.example.buscarep.Enums;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SharedEnums {

    @Retention(RetentionPolicy.RUNTIME)
    @IntDef({ResultadoEntraruser.mSucesso,ResultadoEntraruser.mNadaFazer})
    public @interface ResultadoEntraruser{

        int mNadaFazer = 0,

        mSucesso = 1;

    }
}
