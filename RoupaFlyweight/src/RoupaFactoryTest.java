import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoupaFactoryTest {

    @Test
    void getTamanhoFabrica() {
        Roupa roupa = RoupaFactory.obterRoupa("jeans");
        roupa.setTamanho("XS");
        Roupa roupa1 = RoupaFactory.obterRoupa("jeans");
        roupa1.setImportada(true);
        Roupa roupa2 = RoupaFactory.obterRoupa("jeans");
        roupa2.setTamanho("S");
        Roupa roupa3 = RoupaFactory.obterRoupa("jeans");
        roupa3.setTamanho("M");
        Roupa roupa4 = RoupaFactory.obterRoupa("jeans");
        roupa4.setNova(false);
        Roupa roupa5 = RoupaFactory.obterRoupa("camiseta");
        roupa5.setNova(true);
        Roupa roupa6 = RoupaFactory.obterRoupa("camiseta");
        roupa6.setTamanho("L");

        assertEquals(RoupaFactory.roupaMap.size() == 2, true);
    }

    @Test
    void getTipoSetters() {
        Roupa roupa = RoupaFactory.obterRoupa("jeans");
        roupa.setImportada(true);
        roupa.setTamanho("XS");
        roupa.setNova(false);

        assertEquals(roupa.isImportada(), true);
        assertEquals(roupa.iseNova(), false);
        assertEquals(roupa.getTamanho(), "XS");
        assertEquals(roupa.getTipo(), "jeans");
    }



}