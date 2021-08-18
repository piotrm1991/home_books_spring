package com.springproject.home_books_spring.controllers;

import com.springproject.home_books_spring.domain.entites.Room;
import com.springproject.home_books_spring.domain.entites.StatusType;
import com.springproject.home_books_spring.services.StatusTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StatusTypeController {

    @Autowired
    StatusTypeService statusTypeService;

    @RequestMapping("/statusTypes")
    public String getAllStatusTypes(Model model) {
        List<StatusType> allStatusTypes = this.statusTypeService.getAllStatusTypes();
        model.addAttribute("statusTypes", allStatusTypes);
        return "statusTypes";
    }

    @RequestMapping(value = "/statusTypes", method = RequestMethod.POST)
    public String saveStatusType(@Valid StatusType statusType, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            System.out.println("There were some errors!");
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getObjectName() + error.getDefaultMessage()));
            return "statusTypeForm";
        } else {
            this.statusTypeService.addStatusType(statusType);
            return "redirect:/statusTypes";
        }
    }

    @RequestMapping("/statusType")
    public String createStatusType(Model model) {
        model.addAttribute("statusType", new StatusType());
        return "statusTypeForm";
    }
}
