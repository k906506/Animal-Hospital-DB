package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.service.DogManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class DogController {

    private DogManagementService dogManagementService;

    public void createDog(@RequestBody Dog dog){
        dogManagementService.insertDog(dog);
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs(){
        return dogManagementService.getAllDogs();
    }

    // localhost:8011/dogs
    public Dog getDogByName(@PathVariable String name){
        return dogManagementService.getDogByName(name);
    }

    // HTTP Method : Put
    public Dog changeAllInfo(@RequestBody String oldName, String newName, String newKind, String newOwnerName, String newOwnerPhoneNumber){
        // 이전 강아지 이름으로 모든 variable 변경
        return dogManagementService.changeAllInfo(oldName, newName, newKind, newOwnerName, newOwnerPhoneNumber);
    }
    // HTTP Method : Patch
    public Dog changeDogKind(@RequestBody String dogName, String newKind){
        // dogName으로 dog 검색하여 newKind로 품종 변경
        return dogManagementService.changeDogKind(dogName, newKind);
    }
    // HTTP Method : Patch
    public List<String> addMedicalRecords(@RequestBody String dogName, String newMedicalRecords){
        // dogName으로 dog 검색하여 newMedicalRecords 추가
        return dogManagementService.addMedicalRecords(dogName, newMedicalRecords);
    }
}
