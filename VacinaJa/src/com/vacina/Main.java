package com.vacina;

import java.util.Date;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        //Data e hora de agendamento
        int year = 2021;
        int month = 10;
        int day = 21;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,day);
        Date date = calendar.getTime();

        //Agendamento e Registro da Vacina
        Pessoa pessoa = new Pessoa("Joao","Silva","123456789SSP","PFIZER",date);
        IRegistro registro = new RegistroVacinaProxy();
        registro.registrar(pessoa.dados());



    }
}
