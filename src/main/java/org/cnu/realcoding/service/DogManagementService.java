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

    }

    public Dog getDogByName(String name) {
        Dog dog = dogRepository.findDog(name);

        if(dog == null){
            // throw exception
        }
        return dog;
    }


    public Dog changeDogKind(String dogName, String newKind) {
        Dog dog = dogRepository.findDog(dogName);

        if(dog == null) {
            throw new DogNotFoundException();
        }
        dog = dogRepository.changeDogKind(newKind);

        return dog;
    }

    public List<String> addMedicalRecords(String dogName, String newMedicalRecords) {
        Dog dog = dogRepository.findDog(dogName);

        if(dog == null){
            throw new DogNotFoundException();
        }
        List<String> medicalRecords = dogRepository.addMedicalRecords(newMedicalRecords);
        medicalRecords.add(newMedicalRecords);

        return medicalRecords;
    }

    public Dog changeAllInfo(String oldName, String newName, String newKind, String newOwnerName, String newOwnerPhoneNumber) {
        Dog dog = dogRepository.findDog(oldName);

        if(dog == null){
            throw new DogNotFoundException();
        }
        dog = dogRepository.changeAllInfo(newName, newKind, newOwnerName, newOwnerPhoneNumber);
        return dog;
    }
}
