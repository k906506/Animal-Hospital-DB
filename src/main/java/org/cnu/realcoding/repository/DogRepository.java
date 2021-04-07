package org.cnu.realcoding.repository;

import org.cnu.realcoding.exception.InvalidInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.cnu.realcoding.domain.Dog;
import org.springframework.data.mongodb.core.query.*;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;



@Service
public class DogRepository {
    @Autowired
    MongoTemplate mongoTemplate;


    public void insertDog(Dog dog) {
        mongoTemplate.insert(dog);

    }
    public List<Dog> getAllDogs(){
        return mongoTemplate.findAll(Dog.class);
    }

    public Dog findDog(String value, int i) {
        Criteria cr;
        switch (i){
            case 1:
                cr = new Criteria("name"); // 키 입력
                break;
            case 2:
                cr = new Criteria("ownerName"); // 키 입력
                break;
            case 3:
                cr = new Criteria("ownerPhoneNumber"); // 키 입력
                break;
            default:
                throw new InvalidInput();

        }
        cr.is(value); // 밸류 입력
        Query query = new Query(cr);
        return mongoTemplate.findOne(query, Dog.class); // 조회 후 데이터 반환
    }

    public Dog findDogFromAllParameter(String name, String ownerName, String ownerPhoneNumber) { // 세 가지 파라미터로 dog를 찾는 query문
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("name").is(name)
                                .and("ownerName").is(ownerName)
                                .and("ownerPhoneNumber").is(ownerPhoneNumber)
                        ),
                        Dog.class
                );
    }

    public void changeDogKind(String value,int i, String newKind) {    // dogName 으로 찾은 dog, kind 변경
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
        cri.is(value); // 밸류 입력
        Query query = new Query(cri);
        Update update = Update.update("kind", newKind);
        mongoTemplate.updateFirst(query, update, Dog.class);
    }


    public void addMedicalRecords(String name, String newMedicalRecords) {
        Update up = new Update();
        up.push("medicalRecords").each(newMedicalRecords);
        Query query = new Query(Criteria.where("name").is(name));

        mongoTemplate.updateFirst(query,up,"dog");
    }


    public void changeAllInfo(String name, String newName, String newKind, String newOwnerName, String newOwnerPhoneNumber) {
        //dogName 으로 찾은 dog 의 모든 정보 변경
        Query query = new Query(Criteria.where("name").is(name));
        Update update_name = Update.update("name", newName);
        Update update_kind = Update.update("kind", newKind);
        Update update_OwnerName = Update.update("ownerName", newOwnerName);
        Update update_OwnerPhoneNumber = Update.update("ownerPhoneNumber", newOwnerPhoneNumber);
        mongoTemplate.updateFirst(query, update_kind, Dog.class);
        mongoTemplate.updateFirst(query, update_OwnerName, Dog.class);
        mongoTemplate.updateFirst(query, update_OwnerPhoneNumber, Dog.class);
        mongoTemplate.updateFirst(query, update_name, Dog.class);
    }


    public boolean checkDogName(String name){ // 이름으로 검색
        for(Dog dog : mongoTemplate.findAll(Dog.class)){
            if (dog.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkDogOwner(String Owner){ // 주인이름으로 검색
        for(Dog dog : mongoTemplate.findAll(Dog.class)){
            if (dog.getOwnerName().equals(Owner)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkDogOwnerPhone(String number){ // 주인 번호로 검
        for(Dog dog : mongoTemplate.findAll(Dog.class)){
            if (dog.getOwnerPhoneNumber().equals(number)) {
                return true;
            }
        }
        return false;

    }
}
