package br.com.dh.integra.odonto.service;

import br.com.dh.integra.odonto.domain.Endereco;
import br.com.dh.integra.odonto.domain.Paciente;
import br.com.dh.integra.odonto.util.UtilDate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private Endereco end1 = new Endereco(
            "Av. Mostardeiro", "1255",
            "Porto Alegre", "RS");

    private Paciente pac1 = new Paciente(
            1, "Fernandão", "Colorado",
            "fernandao.inter@internacional.com",
            "214.254.889-06",
            UtilDate.dateToTimestamp(new Date()),
            end1);

    private Endereco end2 = new Endereco(
            "Av. brasil", "630",
            "Pelotas", "RS");

    private Paciente pac2 = new Paciente(
            2, "Taison", "Silva",
            "taison10@internacional.com",
            "122.965.335-97",
            UtilDate.dateToTimestamp(new Date()),
            end2);

    @Override
    public List<Paciente> listPaciente() {
        ArrayList<Paciente> paci = new ArrayList<>();
        paci.add(pac1);
        paci.add(pac2);

        /*for (Paciente p : paci) {
            System.out.println(p);
        }*/

        return paci;
    }

    @Override
    public Paciente buscaPorEmail(String email) {
        if (email.equalsIgnoreCase(pac1.getEmail()))
            return pac1;
        else if (email.equalsIgnoreCase(pac2.getEmail()))
            return pac2;

        return null;
    }

}
