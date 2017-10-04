package com.example.android.connectcodetribe.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.connectcodetribe.R;

/**
 * Created by Admin on 10/4/2017.
 */

public class CodeTribesFragment extends Fragment {
    private Button soweto;
    private Button tembisa;
    private Button pretoria;
    private Button alex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_codetribes,container, false);
        soweto = rootView.findViewById(R.id.codeTribe_soweto);
        tembisa = rootView.findViewById(R.id.codeTribe_tembisa);
        pretoria = rootView.findViewById(R.id.codeTribe_pretoria);
        alex = rootView.findViewById(R.id.codeTribe_alex);
        return rootView;
    }
}
