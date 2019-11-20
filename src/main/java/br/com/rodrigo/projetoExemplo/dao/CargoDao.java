package br.com.rodrigo.projetoExemplo.dao;

import br.com.rodrigo.projetoExemplo.domain.Cargo;

import java.util.List;

// Interface é um recurso da orientação a objeto utilizado em Java que define ações que devem ser obrigatoriamente executadas, mas que cada classe pode executar de forma diferente
public interface CargoDao {

    void save(Cargo cargo );

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();
}
