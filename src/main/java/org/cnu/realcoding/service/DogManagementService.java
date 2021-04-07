package org.cnu.realcoding.service;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.AlreadyExist;
import org.cnu.realcoding.exception.DogNotFoundException;
import org.cnu.realcoding.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return dogRepository.getAllDogs();

    }

    public Dog getDogByName(String name) {
        for (Dog dog : dogRepository.getAllDogs()) {
<<<<<<< HEAD
            System.out.println(dog);
            System.out.println(dog.getName());
            if (dog.getName().equals(name)) { // 이름이 겹치면
=======
            if (dog.getName().equals(name)) { // 이름이 일치하면
>>>>>>> 2ae8da58f09a1e3644dc4292a2dcee7d359afe40
                return dogRepository.findDog(name, 1); // 조회 후 반환
            }
        }
        throw new DogNotFoundException(); // 에러

    }

    public Dog getDogByOwner(String owner){
        for (Dog dog : dogRepository.getAllDogs()) {
            if (dog.getOwnerName().equals(owner)) { // 이름이 일치하면
                return dogRepository.findDog(owner, 2); // 조회 후 반환
            }
        }
        throw new DogNotFoundException(); // 에러
    }

    public Dog getDogByOwnerPhoneNumber(String number){
        for (Dog dog : dogRepository.getAllDogs()) {
            if (dog.getOwnerPhoneNumber().equals(number)) { // 이름이 일치하면
                return dogRepository.findDog(number, 3); // 조회 후 반환
            }
        }
        throw new DogNotFoundException(); // 에러
    }

    public Dog getDogByAllParameter(String name, String ownerName, String ownerPhoneNumber){  // 세 가지 파라미터를 모두 파라미터로 받는 api
        Dog dog = dogRepository.findDogFromAllParameter(name, ownerName, ownerPhoneNumber);
        if (dog == null){
            throw new DogNotFoundException();
        }
        return dog;
    }


    public void changeDogKind(String unique ,String newKind) {
        int i = 0;
        if(dogRepository.checkDogName(unique)) i = 1;
        if(dogRepository.checkDogOwner(unique)) i = 2;
        if(dogRepository.checkDogOwnerPhone(unique)) i = 3;

        Dog dog = dogRepository.findDog(unique, i);

        if(dog == null) {
            throw new DogNotFoundException();
        }
        dogRepository.changeDogKind(unique, i , newKind);
    }

<<<<<<< HEAD
    public void changeAllInfo(String dogName, String newName, String newKind, String newOwnerName, String newOwnerPhoneNumber) {
        Dog dog = dogRepository.findDog(dogName, 1);
        if(dog == null) {
            throw new DogNotFoundException();
        }
        dogRepository.changeAllInfo(dogName, newName,newKind,newOwnerName,newOwnerPhoneNumber);
    }
    public void addMedicalRecords(String dogName, String newMedicalRecords){
        Dog dog = dogRepository.findDog(dogName, 1);
        if(dog == null) {
            throw new DogNotFoundException();
        }
        dogRepository.addMedicalRecords(dogName, newMedicalRecords);
    }
    /*
    public List<String> addMedicalRecords(String dogName, String newMedicalRecords) {
        Dog dog = dogRepository.findDog(dogName, 1);
=======
>>>>>>> 2ae8da58f09a1e3644dc4292a2dcee7d359afe40

    public void changeAllInfo(String dogName, String newName, String newKind, String newOwnerName, String newOwnerPhoneNumber) {
        Dog dog = dogRepository.findDog(dogName, 1);
        if(dog == null) {
            throw new DogNotFoundException();
        }
        dogRepository.changeAllInfo(dogName, newName,newKind,newOwnerName,newOwnerPhoneNumber);
    }
    public void addMedicalRecords(String dogName, String newMedicalRecords){
        Dog dog = dogRepository.findDog(dogName, 1);
        if(dog == null) {
            throw new DogNotFoundException();
        }
        dogRepository.addMedicalRecords(dogName, newMedicalRecords);
    }
}
