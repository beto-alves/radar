package net.betoalves.radar.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.betoalves.radar.R;

/**
 * Created by beto on 02/01/18.
 */

public class FragmentEscola extends Fragment {

    public FragmentEscola() {

    }

    public static FragmentEscola newInstance() {
        return new FragmentEscola();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_escola, container, false);
    }
}