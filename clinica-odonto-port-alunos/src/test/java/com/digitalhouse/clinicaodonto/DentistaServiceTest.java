package com.digitalhouse.clinicaodonto;

import com.digitalhouse.clinicaodonto.impl.DentistaDaoH2;
import com.digitalhouse.clinicaodonto.impl.EnderecoDaoH2;
import com.digitalhouse.clinicaodonto.model.Dentista;
import com.digitalhouse.clinicaodonto.model.Endereco;
import com.digitalhouse.clinicaodonto.service.DentistaService;
import com.digitalhouse.clinicaodonto.service.EnderecoService;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.sql.SQLOutput;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class DentistaServiceTest {
    private static DentistaService dentistaService = new DentistaService(
            new DentistaDaoH2(
                    new EnderecoDaoH2()));
    private EnderecoService enderecoService = new EnderecoService(
            new EnderecoDaoH2());

    @BeforeClass
    public static void carregarDados(){
        Endereco endereco = new Endereco(
            "Praca da Liberdade", "107",
            "São Paulo", "São Paulo");
        Dentista d = dentistaService.cadastrar(new Dentista(
                "Dr. Moreira", "Santos", "321654", endereco));

        Endereco endereco1 = new Endereco(
                "Rua dos Estudantes", "37",
                "São Paulo", "São Paulo");
        Dentista d1 = dentistaService.cadastrar(new Dentista(
                "Dra. Lidia", "Kuwabara", "123654", endereco));
    }

    @Test
    public void cadastrarTest() {
        Endereco endereco = new Endereco(
        "Rua Direita", "685", "São Paulo", "São Paulo");
        Dentista d = dentistaService.cadastrar(new Dentista(
                "Luiz", "Trouxa", "321987", endereco));
    }

    @Test
    public void eliminarDentistaTest(){
        dentistaService.excluir(3);
    }

    @Test
    public void buscarTodosTest(){
        List<Dentista> dentista = dentistaService.buscarTodos();
        System.out.println(dentista);
    }


}
