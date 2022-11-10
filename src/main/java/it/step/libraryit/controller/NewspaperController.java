package it.step.libraryit.controller;

import it.step.libraryit.model.Newspaper;
import it.step.libraryit.service.impl.NewspaperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NewspaperController {

    private final NewspaperServiceImpl newspaperService;

    @Autowired
    public NewspaperController(NewspaperServiceImpl newspaperService) {
        this.newspaperService = newspaperService;
    }

    @GetMapping("/newspapers")
    public String findAll(Model model, @Param("keyword") String keyword) {
        List<Newspaper> newspaper = newspaperService.findAll(keyword);
        model.addAttribute("newspapers", newspaper);
        model.addAttribute("keyword", keyword);
        return "newspaper-list";
    }

    @GetMapping("/newspaper-create")
    public String createNewspaperForm(Newspaper newspaper, Model model) {
        model.addAttribute("newspaper", newspaper);
        return "newspaper-create";
    }

    @PostMapping("/newspaper-create")
    public String createNewspaper(Newspaper newspaper) {
        newspaperService.save(newspaper);
        return "redirect:/newspapers";
    }

    @GetMapping("newspaper-delete/{id}")
    public String deleteNewspaper(@PathVariable("id") Long id) {
        newspaperService.deleteById(id);
        return "redirect:/newspapers";
    }

    @GetMapping("newspaper-update/{id}")
    public String updateNewspaperForm(@PathVariable("id") Long id, Model model) {
        Newspaper newspaper = newspaperService.findById(id);
        model.addAttribute("newspaper", newspaper);
        return "newspaper-update";
    }

    @PostMapping("/newspaper-update")
    public String updateNewspaper(Newspaper newspaper) {
        newspaperService.save(newspaper);
        return "redirect:/newspapers";
    }

}
