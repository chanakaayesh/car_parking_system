package com.system.car.address;

import com.system.car.car.car;
import com.system.car.car.carDetails;
import com.system.car.person.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*@Repository*/
public interface addressRepository extends JpaRepository<address,Long> {

/*    @Query("SELECT s FROM ADDRESS S WHERE S.per_id = ?1")
    Optional<address> findbypersonid(String per_id);*/

    @Query(nativeQuery = true, value = "SELECT * FROM CAR WHERE ADDRESSID = :ID")
    List<carDetails> getCarParkAddress(Long ID);

}
