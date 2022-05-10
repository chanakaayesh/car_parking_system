package com.system.car.car;

import com.system.car.address.address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class carController {
    @Autowired
    private carRepository repository;

    public carController(carRepository repository) {
        this.repository = repository;
    }

    @GetMapping("person/{personid}/cars")
    public List<carDetails> listOfcars(@PathVariable Long personid){

        return repository.findcarsByPersonid(personid);
                        //findcarsByPersonid
    }

    @GetMapping("person/{id}/address")
    public address getparkingAddress(@PathVariable Long id){

        return repository.getCarParkAddress(id);
    }

    @GetMapping("car/{id}")
    public Optional<car> getcarDetails(@PathVariable Long id){

        return repository.findById(id);
    }


    @PostMapping("/save")
    public car saveCar(@RequestBody car model){

        return repository.save(model);
    }

    @PutMapping("person/car/{ID}")
    public  void updateCarOwner(@PathVariable Long ID,@RequestParam Long PERSON_ID){

        repository.updatecarOner(PERSON_ID,ID);

    }




}
