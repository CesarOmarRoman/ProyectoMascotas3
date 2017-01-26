package com.example.maccesarr.proyectomascotas.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maccesarr.proyectomascotas.Adaptadores.AdaptadorMascotas;
import com.example.maccesarr.proyectomascotas.Dominio.Mascota;
import com.example.maccesarr.proyectomascotas.R;
import com.example.maccesarr.proyectomascotas.presentador.IPrincipal_Presenter;
import com.example.maccesarr.proyectomascotas.presentador.Principal_Presenter;
import com.example.maccesarr.proyectomascotas.vista.IPrincipalFragment_View;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment implements IPrincipalFragment_View {

    private RecyclerView listaDeUsuarios;
    private IPrincipal_Presenter presenter;

    public PrincipalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_principal, container, false);
        listaDeUsuarios= (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new Principal_Presenter(this, getContext());
        return v;
    }


    @Override
    public void generarLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaDeUsuarios.setLayoutManager(llm);
    }

    @Override
    public AdaptadorMascotas crearAdaptador(ArrayList<Mascota> mascotas) {
        AdaptadorMascotas adaptadorMascotas = new AdaptadorMascotas(mascotas, getActivity());
        return adaptadorMascotas;
    }

    @Override
    public void inicializarAdaptador(AdaptadorMascotas adaptadorMascotas) {
        listaDeUsuarios.setAdapter(adaptadorMascotas);
    }
}
