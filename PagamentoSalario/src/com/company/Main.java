package com.company;

public class Main {
    public static void main(String[] args) {
        Funcionario funcionario = new Efetivo("Joao","Silva","123456",6000.0,850.0,2500.0);
        funcionario.pagamentoSalario();
        System.out.println("------------------------------------------------------------------");

        funcionario = new Contratado("Jenifer","Mayumi","654321",350.0, 150);
        funcionario.pagamentoSalario();
    }
}
