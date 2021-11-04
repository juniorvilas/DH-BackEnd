package teste.com.dh.medicamentos;

import com.dh.medicamentos.dao.ConfiguracaoJDBC;
import com.dh.medicamentos.dao.impl.MedicamentosDaoH2;
import com.dh.medicamentos.model.Medicamento;
import com.dh.medicamentos.service.MedicamentoService;
import org.junit.Assert;
import org.junit.Test;

public class MedicamentosServiceTest {

    private MedicamentoService medicamentoService =
            new MedicamentoService(
                new MedicamentosDaoH2(
                    new ConfiguracaoJDBC()
                )
            );

    @Test
    public void guadarMedicamento(){
        Medicamento medicamento = new Medicamento(
            "Ibuprofeno",
            "lab123",
            1000,
            200.0);

        medicamentoService.salvar(medicamento);
        Assert.assertTrue(medicamento.getId() != null);
    }

}
