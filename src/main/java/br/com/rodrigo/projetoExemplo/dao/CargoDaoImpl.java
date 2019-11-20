package br.com.rodrigo.projetoExemplo.dao;

import br.com.rodrigo.projetoExemplo.domain.Cargo;
import org.springframework.stereotype.Repository;

// transformando a classe em um bean do Spring
@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

}

