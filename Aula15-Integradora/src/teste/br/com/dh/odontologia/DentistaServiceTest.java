package teste.br.com.dh.odontologia;

//Aluno:Carlindo Silva Queiroz Junor - Turma 03
import br.com.dh.odontologia.dao.configuracao.ConfiguracaoJDBC;
import br.com.dh.odontologia.dao.impl.DentistaDaoH2;
import br.com.dh.odontologia.model.Dentista;
import br.com.dh.odontologia.service.DentistaService;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class DentistaServiceTest {

    private static DentistaService dentistaService =
            new DentistaService(
                    new DentistaDaoH2(
                            new ConfiguracaoJDBC()
                    )
            );


    //Realizar o teste utilizando o JUnit. No teste devemos listar todos os
    //dentistas. Lembre-se de salvar alguns dentistas antes de executá-lo.
    @BeforeClass
    public static void carregarDataSet(){

        Dentista dentista1 = dentistaService.salvar(new Dentista("001","João", "Pedro"));
        Dentista dentista2 = dentistaService.salvar(new Dentista("002","Maria", "Clara"));
        Dentista dentista3 = dentistaService.salvar(new Dentista("003","Daniele", "Carmo"));
        Dentista dentista4 = dentistaService.salvar(new Dentista("004","Mariano", "Maia"));

    }

    //Usar o H2 como banco de dados aplicando o padrão DAO para acessar os
    //dados e executar os métodos necessários para que nos permita salvar um
    //dentista e listar todos os dentistas;

    @Test
    public void trazerTodosDentistas(){
        List<Dentista> dentistas = dentistaService.buscarTodos();
        System.out.println(dentistas);
    }





}
