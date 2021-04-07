package org.cnu.realcoding.repository;

import org.cnu.realcoding.exception.InvalidInput;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.cnu.realcoding.domain.Dog;
import org.springframework.data.mongodb.core.query.*;

import java.util.List;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Service
public class DogRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Getter
    private List<Dog> dogs = new ArrayList<>();

    public List<Dog> getAllDogs(){
        dogs = mongoTemplate.findAll(Dog.class);
        System.out.println(dogs);
        return dogs;
    }
    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);
        //
    }

    public Dog findDogFromName(String name) { // name으로 dog를 찾는 query문
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("name").is(name)),
                        Dog.class
                );
    }

    public void changeDogKind(String name, String newKind) {    // dogName으로 찾은 dog, kind 변경
        Query query = new Query(Criteria.where("name").is(name));
        Update update = Update.update("kind", newKind);
        mongoTemplate.updateFirst(query, update, Dog.class);
    }

    /*
    public List<String> addMedicalRecords(String newMedicalRecords) {
        // return added new List;
    }


    public Dog changeAllInfo(String newName, String newKind, String newOwnerName, String newOwnerPhoneNumber) {

        //mongoTemplate.insert(dog); // 데이터 추
    }
     */

    public boolean checkDogName(String name){ // 이름으로 검색
        for(Dog dog : dogs){
            if (dog.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkDogOwner(String Owner){ // 주인이름으로 검색
        for(Dog dog : dogs){
            if (dog.getOwnerName().equals(Owner)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkDogOwnerPhone(String number){ // 주인 번호로 검
        for(Dog dog : dogs){
            if (dog.getOwnerPhoneNumber().equals(number)) {
                return true;
            }
        }
        return false;

    }
}
