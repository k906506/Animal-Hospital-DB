package org.cnu.realcoding.controller;

import lombok.extern.slf4j.Slf4j;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.AlreadyExist;
import org.cnu.realcoding.exception.DogNotFoundException;
import org.cnu.realcoding.service.DogManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogManagementService dogManagementService;

    @PostMapping("/dogs")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDog(@RequestBody Dog dog){
        System.out.println("hi");
        dogManagementService.insertDog(dog);
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs(){
        return dogManagementService.getAllDogs();
    }
    @GetMapping("/zzz")  // 테스트용!
    public void test(){
        throw new AlreadyExist();
    }
    @GetMapping("/dogs/name/{name}") // name으로 검색할 땐 /name/,,
    public Dog getDogByName(@PathVariable String name){
        return dogManagementService.getDogByName(name);
    }
    @GetMapping("/dogs/ownerName/{ownerName}") // ownerName 검색은 /ownerName/,,
    public Dog getDogByOwner(@PathVariable String ownerName){
        return dogManagementService.getDogByOwner(ownerName);
    }
    @GetMapping("/dogs/ownerPhoneNumber/{ownerPhoneNumber}") // phoneNumber 검색은 /ownerPhoneNumber/,,
    public Dog getDogByPhoneNumber(@PathVariable String ownerPhoneNumber){
        return dogManagementService.getDogByOwnerPhoneNumber(ownerPhoneNumber);
    }

<<<<<<< HEAD

    //HTTP Method : Put
    @PutMapping("/dogs/{oldName}")
=======
    // HTTP Method : Put
>>>>>>> 0392d266e5fb751127c5d8ef1a61e4c9f34405a3
    public void changeAllInfo(@RequestBody String oldName, String newName, String newKind, String newOwnerName, String newOwnerPhoneNumber){
        // 이전 강아지 이름으로 모든 variable 변경
        dogManagementService.changeAllInfo(oldName, newName, newKind, newOwnerName, newOwnerPhoneNumber);
    }


<<<<<<< HEAD

=======
>>>>>>> 0392d266e5fb751127c5d8ef1a61e4c9f34405a3
    // HTTP Method : Patch
    @PatchMapping("/dogs/kind/{kind}")
    public void changeDogKind(@PathVariable String dogName,@RequestBody String newKind){
        // dogName으로 dog 검색하여 newKind로 품종 변경
        dogManagementService.changeDogKind(dogName, newKind);
    }
    // HTTP Method : Patch
    public void addMedicalRecords(@RequestBody String dogName, String newMedicalRecords){
        // dogName으로 dog 검색하여 newMedicalRecords 추가
        dogManagementService.addMedicalRecords(dogName, newMedicalRecords);
    }
}
