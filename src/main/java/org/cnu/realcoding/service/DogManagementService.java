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

    public Dog getDogByName(String name) throws DogNotFoundException { // name만을 파라미터로 받는 api
        Dog dog = dogRepository.findDogFromName(name);
        if (dog == null){
            throw new DogNotFoundException();
        }
        return dog;
    }

    public Dog getDogByOwnerName(String ownerName) throws DogNotFoundException { // ownerName만을 파라미터로 받는 api
        Dog dog = dogRepository.findDogFromOwnerName(ownerName);
        if (dog == null){
            throw new DogNotFoundException();
        }
        return dog;
    }

    public Dog getDogByOwnerPhoneNumber(String ownerPhoneNumber) throws DogNotFoundException {  // ownerPhoneNumber만을 파라미터로 받는 api
        Dog dog = dogRepository.findDogFromOwnerPhoneNumber(ownerPhoneNumber);
        if (dog == null){
            throw new DogNotFoundException();
        }
        return dog;
    }

    public Dog getDogByAllParameter(String name, String ownerName, String ownerPhoneNumber) throws DogNotFoundException {  // 세 가지 파라미터를 모두 파라미터로 받는 api
        Dog dog = dogRepository.findDogFromOwnerPhoneNumber(ownerPhoneNumber);
        if (dog == null){
            throw new DogNotFoundException();
        }
        return dog;
    }





}
