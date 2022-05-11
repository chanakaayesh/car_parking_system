package com.system.car.address;

import com.system.car.car.car;
import com.system.car.car.carDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class addressController {

    @Autowired
    private addressRepository repository ;

    public addressController(addressRepository repository) {
        this.repository = repository;
    }

    //	Get the list of CARs parked at a specific ADDRESS
    @GetMapping("/{id}/cars")
    public List<carDetails> getparkingcars(@PathVariable Long id){

        return repository.getCarParkAddress(id);
    }


}
