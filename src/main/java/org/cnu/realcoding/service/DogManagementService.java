package org.cnu.realcoding.service;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DogManagementService {

    @Autowired
    private DogRepository dogRepository;

    public void insertDog(Dog dog) {
        dogRepository.insertDog(dog);
    }


    public List<Dog> getAllDogs() {
        //return ;
    }

    public Dog getDogByName(String name) {
        Dog dog = dogRepository.findDog(name);

        if(dog == null){
            // throw exception
        }
        return dog;
    }
}
