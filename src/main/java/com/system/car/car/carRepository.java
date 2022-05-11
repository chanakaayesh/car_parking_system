package com.system.car.car;

import com.system.car.address.address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/*@Repository*/

public interface carRepository extends JpaRepository<car,Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM CAR c WHERE c.PERSON_ID = :personid ")
    List<carDetails> findcarsByPersonid(Long personid);


    @Query(nativeQuery = true, value = "SELECT ADDRESS.* FROM CAR LEFT OUTER JOIN ADDRESS ON ADDRESS.ID = CAR.ADDRESSID WHERE CAR.ID= :carid ")
    address getCarParkAddress(Long carid);

    @Transactional
    @Modifying
    @Query(nativeQuery = true ,value = "UPDATE CAR c  SET c.person_id= :person_id WHERE ID=:ID")
    void updatecarOner(Long ID,Long person_id);









}
