package br.com.rodrigo.projetoExemplo.dao;

import br.com.rodrigo.projetoExemplo.domain.Departamento;

import java.util.List;

// Interface é um recurso da orientação a objeto utilizado em Java que define ações que devem ser
// obrigatoriamente executadas, mas que cada classe pode executar de forma diferente
public interface DepartamentoDao {

    void save(Departamento departamento);

    void update(Departamento departamento);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();
}

