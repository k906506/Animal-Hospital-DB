package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
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
        dogManagementService.insertDog(dog);
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs(){
        return dogManagementService.getAllDogs();
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

    @GetMapping("/dogs/AllPara/{name}/{ownerName}/{ownerPhoneNumber}") // 세 가지 변수로 검색은 /AllPara/,,
    public Dog getDogByAllPara(@PathVariable String name, @PathVariable String ownerName, @PathVariable String ownerPhoneNumber) {
        return dogManagementService.getDogByAllParameter(name, ownerName, ownerPhoneNumber);
    }

    @RequestMapping(value="/dogs/change/{unique}/{newKind}" , method = {RequestMethod.GET, RequestMethod.PATCH})
    public String changeDogKind(@PathVariable String unique, @PathVariable String newKind){
        // dogName, ownerName, ownerPhoneNumber로 dog를 검색하여 newKind로 품종 변경.
        dogManagementService.changeDogKind(unique, newKind);
        return "\n품종 변경 완료";
    }

    @RequestMapping(value="/dogs/change/{oldName}/{newName}/{newKind}/{newOwnerName}/{newOwnerPhoneNumber}" , method = {RequestMethod.GET, RequestMethod.PATCH})
    public String changeAllInfo(@PathVariable String oldName, @PathVariable String newName, @PathVariable String newKind, @PathVariable String newOwnerName, @PathVariable String newOwnerPhoneNumber){
        // dogName으로 모든 Data Set 변경.
        dogManagementService.changeAllInfo(oldName, newName, newKind, newOwnerName, newOwnerPhoneNumber);
        return "\nData Set 변경 완료";
    }

    @RequestMapping(value="/dogs/add/{dogName}/{newMedicalRecords}" , method = {RequestMethod.GET, RequestMethod.PATCH})
    public String addMedicalRecords(@PathVariable String dogName, @PathVariable String newMedicalRecords){
        // dogName으로 검색하여 newMedicalRecords 추가.
        dogManagementService.addMedicalRecords(dogName, newMedicalRecords);
        return "\n진료 기록 추가";
    }
}
