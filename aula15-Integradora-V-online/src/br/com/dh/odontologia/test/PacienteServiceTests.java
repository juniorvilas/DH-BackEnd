package br.com.dh.odontologia.test;

import br.com.dh.odontologia.dao.impl.EnderecoDaoH2;
import br.com.dh.odontologia.dao.impl.PacienteDaoH2;
import br.com.dh.odontologia.model.Endereco;
import br.com.dh.odontologia.model.Paciente;
import br.com.dh.odontologia.service.EnderecoService;
import br.com.dh.odontologia.service.PacienteService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class PacienteServiceTests {

    private static PacienteService pacienteService =
        new PacienteService(
            new PacienteDaoH2(
                new EnderecoDaoH2()));
    private EnderecoService enderecoService =
        new EnderecoService(
            new EnderecoDaoH2());

    @BeforeClass
    public static void carregarDataSet() {
        Endereco end1 =
            new Endereco("Av. Brasil", "325", "Centro", "Pelotas");
        Paciente p1 = pacienteService.salvar(
                new Paciente(
                        "Carla", "Santos", "2165784523", new Date(), end1));

        Endereco end2 =
                new Endereco("Rua Santos", "255", "Lapa", "Rio de Janeiro");
        Paciente p2 = pacienteService.salvar(
                new Paciente(
                        "Murilo", "Moreira", "6521447788", new Date(), end2));

        Endereco end3 =
                new Endereco("Av. do Forte", "74", "Jardim das Hortências", "São José");
        Paciente p3 = pacienteService.salvar(
                new Paciente(
                        "Manoel", "Albano", "6485002236", new Date(), end3));

    }

    @Test
    public void cadastrarEBuscarPacienteTest() {
        Endereco end4 =
                new Endereco("Av. Bento Martins", "866", "Centro", "Porto Alegre");
        Paciente p4 = pacienteService.salvar(
                new Paciente(
                        "Richard", "Silveira", "5411778541", new Date(), end4));
        Assert.assertNotNull(pacienteService.buscar(p4.getId()));
    }

    @Test
    public void excluirPacienteTest() {
        pacienteService.excluir(3);
        Assert.assertTrue(pacienteService.buscar(3).isEmpty());
    }

    @Test
    public void trazerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        //Assert.assertTrue(!pacientes.isEmpty());
        //Assert.assertTrue(pacientes.size() == 3);
        System.out.println(pacientes);
    }

}
