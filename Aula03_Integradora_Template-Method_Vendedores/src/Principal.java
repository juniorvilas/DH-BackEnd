public class Principal {
    public static void main(String[] args) {
        System.out.println("\n");

        Funcionario func1 = new Funcionario("Luiz");

        func1.vender();             // +5 pontos
        func1.vender();             // +5 pontos
        func1.setAnos(1);           // 1 anos
        func1.addAnos();            // +1 ano
        func1.obterAfiliado();      // +10 pontos
        func1.vender();             // +5 pontos + 10 pontos = 15 pontos

        func1.mostrarCategoria();   // 35 pontos - categoria bom


        Vendedor func2 = new Afiliado("João");

        func2.vender();             // +15 pontos
        func2.vender();             // +15 pontos
        func2.vender();             // +15 pontos

        func2.mostrarCategoria();   // 45 pontos - categoria mestre


        Vendedor func3 = new Estagiario("Eduardo");

        func3.vender();             // +5 pontos
        func3.vender();             // +5 pontos
        func3.vender();             // +5 pontos
        func3.vender();             // +5 pontos
        func3.vender();             // +5 pontos
        func3.vender();             // +5 pontos
        func3.vender();             // +5 pontos
        func3.vender();             // +5 pontos
        func3.vender();             // +5 pontos
        func3.vender();             // +5 pontos
        func3.vender();             // +5 pontos

        func3.mostrarCategoria();   // 55 pontos - categoria experiente
    }
}
