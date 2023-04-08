package djc.catshop.services;

import djc.catshop.data.Cat;
import djc.catshop.enums.CatBreeds;
import djc.catshop.input.CatInputDto;
import djc.catshop.repositories.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CatService {

    @Autowired
    private CatRepository catRepository;

    public List<Cat> findAll(){
        return catRepository.findAll();
    }

    public Cat findById(Long id){
        return catRepository.findById(id).get();
    }

    public void create(CatInputDto cat){
        Cat newCat = new Cat(cat.getName(), CatBreeds.valueOf(cat.getBreed()), cat.getWeight(), cat.getAge());
        catRepository.save(newCat);
    }

    public void update(Long id, CatInputDto cat){
        catRepository.findById(id).map(record -> {
            record.setName(cat.getName());
            record.setAge(cat.getAge());
            record.setBreed(CatBreeds.valueOf(cat.getBreed()));
            record.setWeight(cat.getWeight());
            return catRepository.save(record);
        });
    }

    public void delete(Long id){
        catRepository.deleteById(id);
    }

}
