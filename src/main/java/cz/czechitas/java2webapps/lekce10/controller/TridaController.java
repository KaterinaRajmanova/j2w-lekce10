package cz.czechitas.java2webapps.lekce10.controller;

import cz.czechitas.java2webapps.lekce10.controller.service.TridaService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TridaController {
    private final TridaService tridaService;

    public TridaController(TridaService tridaService) {
        this.tridaService = tridaService;
    }

    @GetMapping("/")
    public ModelAndView tridy(){
        ModelAndView result= new ModelAndView("index");
        result.addObject("seznam", tridaService.seznamTrid());
        return result;
    }

    @GetMapping("/{id:[0-9]+}")
    public ModelAndView detail(@PathVariable short id){
        ModelAndView result = new ModelAndView("detail");
        result.addObject("detail",tridaService.najdiTridu(id));
        return result;
    }

    @GetMapping("/student/{id:[0-9]+}")
    public ModelAndView student(@PathVariable Integer id){
        ModelAndView result = new ModelAndView("student");
        result.addObject("student",tridaService.najdiStudenta(id));
        return result;
    }

}
