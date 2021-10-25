import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiguraTest {

    Figura quadrado;
    Figura circulo;

    @BeforeEach
    void doBefore() {
        quadrado = new Quadrado(10);

        circulo = new Circulo(15);
    }

    @Test
    void getPerimetro(){
        assertEquals(40,quadrado.calcularPerimetro());
        assertEquals(94.2,circulo.calcularPerimetro());

    }

}