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

    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);
        //
    }

    public Dog findDog(String name, int i) {
        Criteria cri;
        switch (i){
            case 1:
                cri = new Criteria("name"); // 키 입력
                break;
            case 2:
                cri = new Criteria("ownerName"); // 키 입력
                break;
            case 3:
                cri = new Criteria("ownerPhoneNumber"); // 키 입력
                break;
            default:
                throw new InvalidInput();

        }
        cri.is(name); // 밸류 입력
        Query query = new Query(cri);
        Dog dog = (Dog) mongoTemplate.find(query, mongoTemplate.getClass()); // 조회 후 데이터 반환
        return dog;
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
