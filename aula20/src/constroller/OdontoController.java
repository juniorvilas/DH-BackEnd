package constroller;

import domain.Paciente;
import service.OdontoService;

import java.util.Map;

@RestController
public class OdontoController {

    private OdontoService service;

    @GetMapping("listar")
    public Map<Integer, Paciente> listarPacientes(){
        return service.buscarPaciente();
    }

    @GetMapping("criar")
    public Paciente criarPacientes(){
       return service.criarPaciente();
    }

    @GetMapping("deletar/{id}")
    public String deletarPacientes(@PathVariable Integer id){
        service.deletar(id);

        return "Paciente Deletado";
    }


}
