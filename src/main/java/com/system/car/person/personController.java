package com.system.car.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.car.address.address;
import com.system.car.address.addressRepository;
import com.system.car.car.carDetails;
import com.system.car.car.carRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class personController {

    @Autowired
    private  personRepository repository;

    private carRepository carRepositorys;

    private addressRepository addressRepositorys;

    public personController(personRepository repository, carRepository carRepositorys,addressRepository addressRepositorys) {
        this.carRepositorys= carRepositorys;
        this.repository = repository;
        this.addressRepositorys =addressRepositorys ;
    }

    //Get ONE PERSON and his ADDRESSes
    @GetMapping("/{id}/address")
    private Optional<person> getPerson(@PathVariable Long id){

        return repository.findById(id);
    }

    //Get a list of PERSONs, filtered by name and/or birthdate and/or ADDRESS (partial) description
    @GetMapping()
    public List<person> filterall(@RequestParam(required = false) String name, @RequestParam(required = false)@JsonFormat(pattern = "yyyy-MM-dd")  Date birthdate) throws ParseException {

        var personsByBday= repository.findByBirthdate(birthdate);
        return personsByBday;
    }

    //Get the list of CARs owned by one PERSON
    @GetMapping("{personid}/cars")
    public List<carDetails> listOfcars(@PathVariable Long personid){

        return carRepositorys.findcarsByPersonid(personid);
        //findcarsByPersonid
    }

    @GetMapping("/view")
    private List<person> viewperson(){
        return  repository.findAll();
    }

    //Create a PERSON entity
    //Add one ADDRESS to a PERSON
    @PostMapping()
    private person savePerson(@RequestBody person obj){

        return repository.save(obj);
    }
   //Add one ADDRESS to a PERSON
    @PutMapping("{id}/address")
    private address AddAddressToPerson(@PathVariable Long id ,address address){
        address.setPersonid(id);
        return addressRepositorys.save(address);
    }
    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable Long id){

        repository.deleteById(id);
    }

    /*@GetMapping("/filter/all")
    public List<Entity> filterall(@EntityFilter Specification<Entity> pers){

        return  repository.findAll(x=>x.);
    }*/


}
