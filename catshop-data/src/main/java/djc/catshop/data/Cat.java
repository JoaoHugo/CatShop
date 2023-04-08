package djc.catshop.data;

import djc.catshop.enums.CatBreeds;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private CatBreeds breed;

    private float weight;

    private int age;

    public Cat() {
    }

    public Cat(Long id, String name, CatBreeds breed, float weight, int age) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.age = age;
    }

    public Cat(String name, CatBreeds breed, float weight, int age) {
        this.name = name;
        this.breed = breed;
        this.weight = weight;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CatBreeds getBreed() {
        return breed;
    }

    public void setBreed(CatBreeds breed) {
        this.breed = breed;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
