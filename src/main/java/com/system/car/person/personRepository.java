package com.system.car.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.aspectj.weaver.ast.Var;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

//@Repository
public interface personRepository extends JpaRepository<person,Long> {


   public List<person> findByNameOrBirthdate(String name,@JsonFormat(pattern = "yyyy-MM-dd") Date birthdate);
   public List<person> findByBirthdate(@JsonFormat(pattern = "yyyy-MM-dd") Date birthdate);
}
