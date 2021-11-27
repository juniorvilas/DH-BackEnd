package com.example.demo.dto;

public class ConsultaDto {

    private Integer idDentista;
    private Integer idPaciente;
    private Integer idUsuario;
//
//    public Consulta tranformaParaObjeto(){
//        return new Consulta();
//    }



    public Integer getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Integer idDentista) {
        this.idDentista = idDentista;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }


}
