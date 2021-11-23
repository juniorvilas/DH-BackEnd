package br.com.dh.aula21.idade.service;

import br.com.dh.aula21.idade.service.impl.IPessoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class PessoaService implements IPessoService {


    @Override
    public Integer calcularIdade(Integer dia, Integer mes, Integer ano){
        LocalDate date = LocalDate.of(ano,mes, dia);
        Period period = Period.between(date, LocalDate.now());
        return Math.abs(period.getYears());
    }

}
