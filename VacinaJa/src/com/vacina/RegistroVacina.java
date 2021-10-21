package com.vacina;

public class RegistroVacina implements IRegistro{

    //Método registrar oficial, que exibe o registro da vacina!
    @Override
    public void registrar(Object[] dados) {
        System.out.println("Foi registrado o RG: " + dados[0] + " na data: " + dados[1].toString() + " como vacinado");
    }
}
