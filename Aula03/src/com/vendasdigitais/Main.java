package com.vendasdigitais;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================================================");

        Funcionarios func1 = new Funcionarios("Wheslley");
        func1.addAnos(); // 1 ano
        func1.vender(); // 5 pontos + 5 (1ano) = 10
        func1.vender(); // 5 pontos + 5 (1ano) = 10
        func1.obterAfiliado();// 10 pontos
        func1.mostrarCategoria(); // 30 pontos
        System.out.println("=========================================================================");

        Vendedores afiliado = new Afiliado("Maria");
        afiliado.vender();// 15
        afiliado.vender(); // 15
        afiliado.mostrarCategoria(); // 30
        System.out.println("=========================================================================");
        Vendedores estagiario = new Estagiario("Pedro");
        System.out.println("Resumo de pontos do Estagiário: ");
        estagiario.vender();// 5
        estagiario.vender();// 5
        estagiario.mostrarCategoria(); // 10
        System.out.println("==========================================================================");
    }
}
