package com.example.buscarep.Enums;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SharedEnums {

    @Retention(RetentionPolicy.RUNTIME)
    @IntDef({quantidadeFragment.quantidadeFragment})
    public @interface quantidadeFragment {

        int quantidadeFragment = 2,

        firstFragment = 0,

        secondFragment = 1;

    }

    @Retention(RetentionPolicy.RUNTIME)
    @IntDef({numeroTab.firstTab,numeroTab.secondTab})
    public @interface numeroTab{

        int firstTab = 0,

        secondTab = 1;
    }
}
