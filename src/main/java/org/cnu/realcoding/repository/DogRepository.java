package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;

import java.util.List;

public class DogRepository {

    public void insertDog(Dog dog) {
        // mongoTemplate.insert(dog);
    }

    public Dog findDog(String name) {
        // return mongoTemplate
    }


    public Dog changeDogKind(String newKind) {
        // return changedDog
    }

    public List<String> addMedicalRecords(String newMedicalRecords) {
        // return added new List;
    }

    public Dog changeAllInfo(String newName, String newKind, String newOwnerName, String newOwnerPhoneNumber) {
        // mongoTemlate;
    }
}
