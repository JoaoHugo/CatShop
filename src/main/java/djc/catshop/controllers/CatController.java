package djc.catshop.controllers;

import djc.catshop.models.Cat;
import djc.catshop.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatRepository catRepository;

    @GetMapping
    public List<Cat> findAll(){
        return catRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cat findById(@PathVariable(name = "id") Long id){
        return catRepository.findById(id).get();
    }

}
