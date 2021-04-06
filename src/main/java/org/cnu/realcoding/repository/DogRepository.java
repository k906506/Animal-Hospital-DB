package org.cnu.realcoding.repository;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
<<<<<<< HEAD
=======
import org.cnu.realcoding.exception.DogNotFoundException;
>>>>>>> a8bb27ac6b044924edd9c05ed529082478bd79fd
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
>>>>>>> a8bb27ac6b044924edd9c05ed529082478bd79fd

@Repository
public class DogRepository {
    @Autowired
    MongoTemplate mongoTemplate;
    @Getter
    @Autowired
    private List<Dog> dogs = new ArrayList<>();

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertDog(Dog dog) {
<<<<<<< HEAD
        mongoTemplate.insert(dog);
    }

    public Dog findDogFromName(String name) { // name으로 dog를 찾는 query문
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("name").is(name)),
                        Dog.class
                );
    }

    public Dog findDogFromOwnerName(String ownerName) { // ownerName으로 dog를 찾는 query문
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("ownerName").is(ownerName)),
                        Dog.class
                );
    }

    public Dog findDogFromOwnerPhoneNumber(String ownerPhoneNumber) { // ownerPhoneNumber로 dog를 찾는 query문
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)),
                        Dog.class
                );
    }

    /* where절 오류 해결 필요.
    public Dog findDogFromAllParameter(String name, String ownerName, String ownerPhoneNumber) { // 세 가지 파라미터로 dog를 찾는 query문
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("name", "ownerName", "ownerPhoneNumber").is(name, ownerName, ownerPhoneNumber)),
                        Dog.class
                );
=======
        mongoTemplate.insert(dog); // 데이터 추
    }

    public Dog findDog(String name) {
        Criteria cri = new Criteria("name"); // 키 입력
        cri.is(name); // 밸류 입력
        Query query = new Query(cri);
        Dog dog = (Dog) mongoTemplate.find(query, mongoTemplate.getClass()); // 조회 후 데이터 반환
        return dog;
    }
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
>>>>>>> a8bb27ac6b044924edd9c05ed529082478bd79fd
    }
    */

}
