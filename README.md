```java
# 기능 1. 강아지 이름으로 검색 -> 구현 O
http://localhost:8011/dogs/name/{dogName}
```


```java
# 기능 2. 주인 이름으로 검색 -> 구현 O
http://localhost:8011/dogs/ownerName/{ownerName}
```


```java
# 기능 3. 주인 폰 번호로 검색 -> 구현 O
http://localhost:8011/dogs/ownerPhoneNumber/{ownerPhoneNumber}
```


```java
# 기능 4. 강아지 이름, 주인 이름, 주인 폰 번호로 검색 -> 구현 O
http://localhost:8011/dogs/AllPara/{dogName}/{ownerName}/{ownerPhoneNumber}
```


```java
# 기능 5. 강아지 이름, 주인 이름, 주인 폰 번호 중 하나로 검색하고 해당 강아지 품종 변경 -> 구현 O
http://localhost:8011/dogs/change/{unique}/{newKind}
```


```java
# 기능 6. 강아지 이름으로 검색하고 모든 data set 변경 -> 구현 O
http://localhost:8011/dogs/change/{oldName}/{newName}/{newKind}/{newOwnerName}/{newOwnerPhoneNumber}
```


```java
# 기능 7. 강아지 이름으로 검색하고 새로운 건강검진 기록 추가 -> 구현 O
http://localhost:8011/dogs/add/{dogName}/{newMedicalRecords}
```

# 모든 기능 구현 완료! 😁
