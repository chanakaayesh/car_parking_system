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

/*

    @GetMapping("person/{id}/address")
    public address getparkingAddress(@PathVariable Long id){

        return repository.getCarParkAddress(id);
    }
*/
//Get detailed information about one CAR
    @GetMapping("{id}")
    public Optional<car> getCarDetails(@PathVariable Long id){

        return repository.findById(id);
    }

 //Create a CAR entity
    @PostMapping()
    public car saveCar(@RequestBody car model){

        car Car = repository.save(model);
        return Car;
    }

    //Transfer ownership of a CAR from one PERSON to another
    @PutMapping("{ID}")
    public  void updateCarOwner(@PathVariable Long ID,@RequestParam Long person_id){

        repository.updatecarOner(ID,person_id);

    }




}
