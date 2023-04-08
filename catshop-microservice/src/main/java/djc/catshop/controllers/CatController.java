package djc.catshop.controllers;

import djc.catshop.data.Cat;
import djc.catshop.input.CatInputDto;
import djc.catshop.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping
    public ResponseEntity<List<Cat>> findAll(){
        return new ResponseEntity<>(catService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cat> findById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(catService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CatInputDto cat){
        catService.create(cat);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(name = "id") Long id, @RequestBody CatInputDto cat){
        catService.update(id, cat);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        catService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
