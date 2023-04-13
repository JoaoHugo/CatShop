package djc.catshop.services;

import djc.catshop.data.Cat;
import djc.catshop.output.FeeOutputDto;
import djc.catshop.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FeeService {
    @Autowired
    private CatRepository catRepository;
    @Value("${catshop.initialFee}")
    private String initialFee;

    public FeeOutputDto getFeeValue(Long catId){
       Cat cat =  catRepository.findById(catId).get();
       Double fee = Double.valueOf(initialFee);

       if(cat.getAge() <= 1) {
           fee += 200;
       }else if(cat.getAge() > 10){
           fee +=  300;
        }
       if(cat.getWeight() >= 4){
           fee += 150;
       }
      return new FeeOutputDto(fee);
    }


}
