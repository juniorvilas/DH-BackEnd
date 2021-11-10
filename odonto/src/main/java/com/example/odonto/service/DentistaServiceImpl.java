package com.example.odonto.service;

import com.example.odonto.domain.Dentista;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DentistaServiceImpl implements IDentistaService{


    private Dentista dent1 = new Dentista(
            1,
            "Ricardo",
            "Silva",
            "123456"
    );

    private Dentista dent2 = new Dentista(
            1,
            "Pedro",
            "Souza",
            "654321"
    );

    @Override
    public List<Dentista> listaDentista() {
        ArrayList<Dentista> dentistas = new ArrayList<>();
        dentistas.add(dent1);
        dentistas.add(dent2);
        return dentistas;
    }

    @Override
    public Dentista buscar(Integer id) {
        if(id.equals(dent1.getId()))
            return dent1;
        else if(id.equals(dent1.getId()))
            return dent2;

        return null;
    }
}
