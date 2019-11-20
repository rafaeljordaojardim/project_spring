package br.com.rodrigo.projetoExemplo.web.controller;

import br.com.rodrigo.projetoExemplo.domain.*;
import br.com.rodrigo.projetoExemplo.service.CargoService;
import br.com.rodrigo.projetoExemplo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;
    @Autowired
    private CargoService serviceCargo;
    @GetMapping("/cadastrar")
    public String cadastrar(Funcionario funcionario) {
        return "/funcionario/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("funcionarios", service.buscarTodos());
        return "/funcionario/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Funcionario funcionario, RedirectAttributes attr) {
        service.salvar(funcionario);
        attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");
        return "redirect:/funcionarios/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("funcionario", service.buscarPorId(id));
        return "funcionario/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Funcionario funcionario, RedirectAttributes attr) {
        service.editar(funcionario);
        attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
        return "redirect:/funcionarios/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
            service.excluir(id);
        return "redirect:/funcionarios/listar";
    }

    @GetMapping("/buscar/nome")
    public String excluir(@RequestParam("nome") String nome, ModelMap model) {
        model.addAttribute("funcionarios", service.buscarPorNome(nome));
        return "redirect:/funcionario/lista";
    }
    @GetMapping("/buscar/cargo")
    public String excluir(@RequestParam("id") Long id, ModelMap model) {
        model.addAttribute("funcionarios", service.buscarPorCargo(id));
        return "redirect:/funcionario/lista";
    }
    @GetMapping("/buscar/data")
    public String excluir(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                          @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                            ModelMap model) {
        model.addAttribute("funcionarios", service.buscarPorDatas(entrada, saida));
        return "redirect:/funcionario/lista";
    }

    @ModelAttribute("cargos")
    public List<Cargo> getCargos() {
        return serviceCargo.buscarTodos();
    }

    @ModelAttribute("ufs")
    public UF[] getUFs() {
        return UF.values();
    }
}

