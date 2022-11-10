package it.step.libraryit.controller;

import it.step.libraryit.model.Magazine;
import it.step.libraryit.service.impl.MagazinesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MagazinesController {

    private final MagazinesServiceImpl magazinesService;

    @Autowired
    public MagazinesController(MagazinesServiceImpl magazinesService) {
        this.magazinesService = magazinesService;
    }


    @GetMapping("/magazines")
    public String findAll(Model model, @Param("keyword") String keyword) {
        List<Magazine> magazine = magazinesService.findAll(keyword);
        model.addAttribute("magazines", magazine);
        model.addAttribute("keyword", keyword);
        return "magazine-list";
    }

    @GetMapping("/magazine-create")
    public String createMagazineForm(Magazine magazine, Model model){
        model.addAttribute("magazine", magazine);
        return "magazine-create";
    }

    @PostMapping("/magazine-create")
    public String createMagazine( Magazine magazine){
        magazinesService.save(magazine);
        return "redirect:/magazines";
    }

    @GetMapping("magazine-delete/{id}")
    public String deleteMagazines(@PathVariable("id") Long id){
        magazinesService.deleteById(id);
        return "redirect:/magazines";
    }

    @GetMapping("magazine-update/{id}")
    public String updateMagazineForm(@PathVariable("id") Long id, Model model){
        Magazine magazine = magazinesService.findById(id);
        model.addAttribute("magazine", magazine);
        return "magazine-update";
    }

    @PostMapping("/magazine-update")
    public String updateMagazine(Magazine magazine){
        magazinesService.save(magazine);
        return "redirect:/magazines";
    }
}
