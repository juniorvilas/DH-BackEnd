package com.digitalhouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlyweightTest {

    @Test
    void getTamanhoFabrica() {
        Roupa roupa = FlyweightFactory.obterRoupa("jeans");
        roupa.setTamanho("XS");
        Roupa roupa1 = FlyweightFactory.obterRoupa("jeans");
        roupa1.setImportada(true);
        Roupa roupa2 = FlyweightFactory.obterRoupa("jeans");
        roupa2.setTamanho("S");
        Roupa roupa3 = FlyweightFactory.obterRoupa("jeans");
        roupa3.setTamanho("M");
        Roupa roupa4 = FlyweightFactory.obterRoupa("jeans");
        roupa4.setNova(false);
        Roupa roupa5 = FlyweightFactory.obterRoupa("camiseta");
        roupa5.setNova(true);
        Roupa roupa6 = FlyweightFactory.obterRoupa("camiseta");
        roupa6.setTamanho("L");

        assertEquals(FlyweightFactory.roupaMap.size() == 2, true);
    }

    @Test
    void getTipoSetters() {
        Roupa roupa = FlyweightFactory.obterRoupa("jeans");
        roupa.setImportada(true);
        roupa.setTamanho("XS");
        roupa.setNova(false);

        assertEquals(roupa.isImportada(), true);
        assertEquals(roupa.isNova(), false);
        assertEquals(roupa.getTamanho(), "XS");
        assertEquals(roupa.getTipo(), "jeans");
    }

}
