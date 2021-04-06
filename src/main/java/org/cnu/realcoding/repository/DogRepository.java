package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class DogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertDog(Dog dog) {
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
    }
    */

}
