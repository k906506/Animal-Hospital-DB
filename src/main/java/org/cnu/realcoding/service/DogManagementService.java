package org.cnu.realcoding.service;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.AlreadyExist;
import org.cnu.realcoding.exception.DogNotFoundException;
import org.cnu.realcoding.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class DogManagementService {

    @Autowired
    private DogRepository dogRepository;


    public void insertDog(Dog dog) {
        if( dogRepository.checkDogName(dog.getName()) // 이름 중복 검사
                || dogRepository.checkDogOwner(dog.getOwnerName()) // 주인 이름 중복 검사
                || dogRepository.checkDogOwnerPhone(dog.getOwnerPhoneNumber()) /* 폰 번호 중복 검사 */){
            throw new AlreadyExist();
        }
        dogRepository.insertDog(dog);
    }


    public List<Dog> getAllDogs() {
        return dogRepository.getDogs();
    }

    public Dog getDogByName(String name) {
        for (Dog dog : dogRepository.getDogs()) {
            if (!dog.getName().equals(name)) { // 이름이 겹치면
                throw new DogNotFoundException(); // 에러
            }
        }
        return dogRepository.findDog(name); // 조회 후 반환
    }

    public Dog getDogByOwner(String owner){
        for (Dog dog : dogRepository.getDogs()) {
            if (!dog.getName().equals(owner)) { // 주인 이름이 겹치면
                throw new DogNotFoundException(); // 에러
            }   
        }
        return dogRepository.findDog(owner); // 조회 후 반환
    }

    public Dog getDogByOwnerPhoneNumber(String number){
        for (Dog dog : dogRepository.getDogs()) {
            if (!dog.getName().equals(number)) { // 폰 번호가 겹치면
                throw new DogNotFoundException();// 에러
            }
        }
        return dogRepository.findDog(number); // 조회 후 반환
    }
}
