package com.example.odonto.service;

import com.example.odonto.domain.Dentista;
import com.example.odonto.domain.Endereco;
import com.example.odonto.domain.Paciente;
import com.example.odonto.util.UtilDate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService{


    private Endereco end1 = new Endereco(
            "Av. Mostardeiro",
            "25",
            "Porto Alegre",
            "RS");

    private Dentista dent1 = new Dentista(
            1,
            "Ricardo",
            "Silva",
            "123456"
    );

    private Paciente pac1 = new Paciente(
            1,"Fernando", "Colorado",
            "fernando@gmail.com","12345678948",
            UtilDate.dateToTimestamp(new Date()),
            end1, dent1);

    private Endereco end2 = new Endereco(
            "Av. Brasil",
            "50",
            "Porto Alegre",
            "RS");

    private Dentista dent2 = new Dentista(
            1,
            "Pedro",
            "Souza",
            "654321"
    );


    private Paciente pac2 = new Paciente(
            1,"Joao", "Silva",
            "joao@gmail.com","45454875454",
            UtilDate.dateToTimestamp(new Date()),
            end2, dent2);




    @Override
    public List<Paciente> listPaciente() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.add(pac1);
        pacientes.add(pac2);

        //for (Paciente p : pacientes){
        //    System.out.println(p);
        //    }

        return pacientes;
    }

    @Override
    public Paciente buscaPorEmail(String email) {
        if(email.equalsIgnoreCase(pac1.getEmail()))
            return pac1;
        else if(email.equalsIgnoreCase(pac2.getEmail()))
            return pac2;

        return null;
    }
}
