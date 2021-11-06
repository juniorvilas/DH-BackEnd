package teste.br.com.dh.odontologia;

import br.com.dh.odontologia.dao.impl.EnderecoDaoH2;
import br.com.dh.odontologia.dao.impl.PacienteDaoH2;
import br.com.dh.odontologia.model.Endereco;
import br.com.dh.odontologia.model.Paciente;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;
import br.com.dh.odontologia.service.EnderecoService;
import br.com.dh.odontologia.service.PacienteService;


import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class PacienteServiceTest {

    private static PacienteService pacienteService =
            new PacienteService(
                    new PacienteDaoH2(
                            new EnderecoDaoH2()
                    )
            );
    private EnderecoService enderecoService = new EnderecoService(new EnderecoDaoH2());

    @BeforeClass
    public static void carregarDataSet() {
        Endereco endereco = new Endereco("Av. Avenida Eudorado", "444", "São Paulo", "Centro");
        Paciente p = pacienteService.salvar(new Paciente("Carlos", "Alberto", "88888888", new Date(), endereco));
        Endereco endereco1 = new Endereco("Av. Avenida do Forte", "333", "Porto Alegre", "Santana");
        Paciente p1 = pacienteService.salvar(new Paciente("Marcela", "Moura", "99999999", new Date(), endereco1));
    }

    @Test
    public void cadastrarEBuscarPacienteTest() {
        Endereco endereco = new Endereco("Av. São João", "123", "Rio de Janeiro", "Copacabana");
        Paciente p3 = pacienteService.salvar(new Paciente("Marcio", "Oliveira", "12345678", new Date(), endereco));
        Assert.assertNotNull(pacienteService.buscar(p3.getId()));
    }

    @Test
    public void excluirPacienteTest() {
        pacienteService.excluir(3);
        Assert.assertTrue(pacienteService.buscar(3).isEmpty());

    }

    @Test
    public void trazerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 2);
        System.out.println(pacientes);
    }
}
