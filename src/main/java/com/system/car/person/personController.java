package com.system.car.person;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    public personController(personRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    private Optional<person> getPerson(@PathVariable Long id){

        return repository.findById(id);
    }

    @GetMapping()
    public List<person> filterall(@RequestParam(required = false) String name, @RequestParam(required = false)@JsonFormat(pattern = "yyyy-MM-dd")  Date birthdate) throws ParseException {

        // return  null;
        var personsByName = repository.findByNameOrBirthdate(name,birthdate);


        // Date da =  new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);

        var personsByBday= repository.findByBirthdate(birthdate);
        return personsByBday;
    }




    @GetMapping("/view/list/person")
    private List<person> viewperson(){
        return  repository.findAll();
    }

    @PostMapping("/insert/person")
    private person savePerson(@RequestBody person obj){

        return repository.save(obj);
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
