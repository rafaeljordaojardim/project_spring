package br.com.rodrigo.projetoExemplo.service;

import br.com.rodrigo.projetoExemplo.domain.Cargo;

import java.util.List;


public interface CargoService {

    void salvar(Cargo cargo);

    void editar(Cargo cargo);

    void excluir(Long id);

    Cargo buscarPorId(Long id);

    List<Cargo> buscarTodos();

    boolean cargoTemFuncionarios(Long id);
}
