package org.cnu.realcoding.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.cnu.realcoding.domain.Dog;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class DogRepository {

    private MongoTemplate mongoTemplate;
    public void insertDog(Dog dog) {
        //
    }

    public Dog findDog(String name) {
        return mongoTemplate.
                findOne(
                        Query.query(Criteria.where("name").is(name)), Dog.class);
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
