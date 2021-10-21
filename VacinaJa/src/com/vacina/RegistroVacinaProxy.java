package com.vacina;

import java.util.Date;

public class RegistroVacinaProxy implements IRegistro{

    //Proxy que controla se a vacina está ocorrendo dentro da data agendada ou posterior a ela
    @Override
    public void registrar(Object[] dados) {
        if(verificarData((Date) (dados[1]))){
            RegistroVacina registro = new RegistroVacina();
            registro.registrar(dados);
        } else {
            System.out.println("Não pode registrar para data futura");
        }
    }
        //Verifica se a data é antes ou igual a data atual, se for ela registra
        //Data futura não registra!
    public boolean verificarData (Date data) {
        return data.before(new Date());
    }

}
