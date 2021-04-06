package org.cnu.realcoding.controller;

import lombok.extern.slf4j.Slf4j;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.AlreadyExist;
import org.cnu.realcoding.exception.DogNotFoundException;
import org.cnu.realcoding.service.DogManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class DogController {

    private DogManagementService dogManagementService;

    @PostMapping("/dogs")
    public void createDog(@RequestBody Dog dog){
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

}
