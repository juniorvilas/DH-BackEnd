package com.digitalhouse.junit.exercicio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    Pessoa pessoa0, pessoa1, pessoa2;

    @BeforeEach
    void doBefore() {
        pessoa0 = new Pessoa("Gaspar","Sousa");
        pessoa0.setIdade(LocalDate.of(1990,6,23));

        pessoa1 = new Pessoa("Nathalia","Viera");
        pessoa1.setIdade(LocalDate.of(1990,10,3));

        pessoa2 = new Pessoa("Caio","Castro");
        pessoa2.setIdade(LocalDate.of(1978,5,4));
    }

    @Test
    void getNomeCompleto(){
        assertEquals("Gaspar, Sousa",pessoa0.calcularNomeCompleto());
        assertEquals("Nathalia, Viera",pessoa1.calcularNomeCompleto());
        assertEquals("Caio, Castro",pessoa2.calcularNomeCompleto());
    }


    @Test
    void getEMaiorDe18() {
        assertEquals(pessoa0.eMaiorDeIdade(),true);
        assertEquals(pessoa1.eMaiorDeIdade(),true);
        assertEquals(pessoa2.eMaiorDeIdade(),true);
    }


}