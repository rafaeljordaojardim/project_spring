package br.com.rodrigo.projetoExemplo.dao;

import br.com.rodrigo.projetoExemplo.domain.Departamento;
import org.springframework.stereotype.Repository;

// transformando a classe em um bean do Spring
@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long>
        implements DepartamentoDao {

}


