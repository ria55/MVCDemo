package application.controllers;

import application.models.FunForm;
import application.services.FunFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    private FunFormService service;

    @Autowired
    public FormController(FunFormService service) {
        this.service = service;
    }

    @GetMapping("/form")
    public String getFormPage(@ModelAttribute("myForm") FunForm form) {
        return "form";
    }

    @PostMapping("/form")
    public String sendForm(@ModelAttribute("myForm") FunForm userFunForm, Model model) {
        model.addAttribute("name", service.getNameWithText(userFunForm));
        model.addAttribute("age", service.getAgeWithText(userFunForm));
        model.addAttribute("favorite", service.getFavoriteWithText(userFunForm));
        return "success";
    }

}
