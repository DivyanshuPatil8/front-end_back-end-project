package com.example.thymeleaf_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkerController {
    @Autowired
    WorkerService  wser;
   
    @GetMapping("/")
    public String viewHomePage(Model model)
    {
        model.addAttribute("allworlist", wser.getAllWorker());
        return "Home";
    }
    @GetMapping("/addnew")
    public String addNewWorker(Model model)
    {
        Worker worker =new Worker();
        model.addAttribute("worker", worker);
        return "AddNew";
    }
    @PostMapping("/save")
    public String saveWorker(@ModelAttribute ("worker") Worker worker){
        wser.save(worker);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable (value = "id") long id ,Model model){
        Worker worker =wser.getById(id);
        model.addAttribute("worker", worker);
        return "Update";
    }
    @GetMapping("/deleteWorker/{id}")  
     public String deleteThroughId(@PathVariable (value = "id") long id)
     {
          wser.deleteViaId(id);
          return "redirect:/";
     }                                                                                                                          
}
