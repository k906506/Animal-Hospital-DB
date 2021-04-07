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

    @GetMapping("/test")  // 테스트용!
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
    public Dog getDogByPhoneNumber(@PathVariable String ownerPhoneNumber) {
        return dogManagementService.getDogByOwnerPhoneNumber(ownerPhoneNumber);
    }

    @RequestMapping(value="/dogs/{name}/change/{newKind}" , method = {RequestMethod.GET, RequestMethod.PATCH})
    public void changeDogKind(@PathVariable String name,@PathVariable String newKind){
        // dogName으로 dog 검색하여 newKind로 품종 변경
        System.out.print("Kind Changed");
        dogManagementService.changeDogKind(name, newKind);
    }

    @RequestMapping(value="/dogs/change/{oldName}/{newName}/{newKind}/{newOwnerName}/{newOwnerPhoneNumber}" , method = {RequestMethod.GET, RequestMethod.PATCH})
    public void changeAllInfo(@PathVariable String oldName, @PathVariable String newName, @PathVariable String newKind, @PathVariable String newOwnerName, @PathVariable String newOwnerPhoneNumber){
        // 이전 강아지 이름으로 모든 variable 변경
        System.out.print("All info Changed");
        dogManagementService.changeAllInfo(oldName, newName, newKind, newOwnerName, newOwnerPhoneNumber);
    }

    @RequestMapping(value="/dogs/{dogName}/add/{newMedicalRecords}" , method = {RequestMethod.GET, RequestMethod.PATCH})
    public void addMedicalRecords(@PathVariable String dogName, @PathVariable String newMedicalRecords){
        // dogName으로 dog 검색하여 newMedicalRecords 추가
        dogManagementService.addMedicalRecords(dogName, newMedicalRecords);
    }
}
