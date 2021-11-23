package service;

import domain.Paciente;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OdontoService {

    private static Map<Integer, Paciente> mapa = new HashMap<>();

    private static String[] nomes = {
            "Antonio", "Marta","Bianca", "Creuza","Patrick",
                    "Jonas","Paula", "Ana","Fernanda", "Patricia"};

    private static String[] sobrenomes = {
            "Moraes", "Silva","Queiroz", "Souza","Carmo",
            "Gomes","Andrade", "Oliveira","Santos", "Nunes"};

    public Paciente criarPaciente(){
        Random random = new Random();
        int upperbound = 10; //upperbound limite de 10
        String nome = nomes[random.nextInt(upperbound)];
        String sobrenome = sobrenomes[random.nextInt(upperbound)];
        String email = nome.toLowerCase() + sobrenome.toLowerCase() + "dh.com";
        Integer id = mapa.size() + 1;
        mapa.put(id, new Paciente(
                nome, sobrenome, email,
                (random.nextInt(upperbound) + 18)));

        return mapa.get(id);

    }

    public Map<Integer,Paciente> buscarPaciente(){
        return mapa;
    }

    public void deletar(Integer id){
        mapa.remove(id);
    }




}
