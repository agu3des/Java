package br.edu.ifpb.pweb2.bitbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.pweb2.bitbank.model.Correntista;
import br.edu.ifpb.pweb2.bitbank.service.CorrentistaService;

@Controller
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaService correntistaService;

    
    @GetMapping("/form")
    public String getForm(Correntista correntista, Model model) {
        model.addAttribute("correntista", correntista);
        return "correntistas/form";
    }

    @PostMapping
    public ModelAndView save(Correntista correntista, ModelAndView model, RedirectAttributes attr) {
        correntistaService.save(correntista);
        attr.addFlashAttribute("mensagem", "Correntista cadastrado com sucesso!");
        model.setViewName("redirect:correntistas");
        return model;
    }

    @GetMapping
    public ModelAndView listAll(ModelAndView model) {
        model.addObject("correntistas", correntistaService.findAll());
        model.setViewName("correntistas/list");
        return model;
    }

    @GetMapping("/{id}")
    public String getCorrentistaById(@PathVariable(value = "id") Integer id, Model model) {
        model.addAttribute("correntista", correntistaService.findById(id));
        return "correntistas/form";
    }
}
