package djc.catshop.controllers;

import djc.catshop.services.FeeService;
import djc.catshop.output.FeeOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fees")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @GetMapping("/cat/{id}")
    public ResponseEntity<FeeOutputDto> getFeeByCatId(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(feeService.getFeeValue(id), HttpStatus.OK);
    }
}
