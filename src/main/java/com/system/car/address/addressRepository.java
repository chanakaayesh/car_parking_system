package com.system.car.address;

import com.system.car.person.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*@Repository*/
public interface addressRepository extends JpaRepository<address,Long> {

/*    @Query("SELECT s FROM ADDRESS S WHERE S.per_id = ?1")
    Optional<address> findbypersonid(String per_id);*/

}
