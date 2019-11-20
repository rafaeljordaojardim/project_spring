package br.com.rodrigo.projetoExemplo.service;

import br.com.rodrigo.projetoExemplo.domain.Departamento;

import java.util.List;


public interface DepartamentoService {

    void salvar(Departamento departamento);

    void editar(Departamento departamento);

    void excluir(Long id);

    Departamento buscarPorId(Long id);

    List<Departamento> buscarTodos();

    boolean departamentoTemCargos(Long id);
}

