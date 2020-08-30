package com.example.buscarep.FragmentPageAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.buscarep.Enums.SharedEnums;
import com.example.buscarep.Fragments.FragShowAnunciar;
import com.example.buscarep.Fragments.FragShowRoom;
import com.example.buscarep.Util.MensagemSistema;

public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public PageAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case SharedEnums.quantidadeFragment.firstFragment:
                return FragShowRoom.newInstance(SharedEnums.quantidadeFragment.firstFragment);
            case SharedEnums.quantidadeFragment.secondFragment:
                return FragShowAnunciar.newInstance(SharedEnums.quantidadeFragment.secondFragment);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return SharedEnums.quantidadeFragment.quantidadeFragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case SharedEnums.quantidadeFragment.firstFragment:
                return MensagemSistema.INICIO;
            case SharedEnums.quantidadeFragment.secondFragment:
                return MensagemSistema.ANUNCIAR;
        }
        return null;
    }
}
