package com.system.car.address;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.system.car.car.car;
import com.system.car.person.person;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="streetname")
    private  String streetname ;

    @Column(name="number")
    private int number;

    @Column(name="ZIPcode")
    private  int zipcode ;

    @Column(name="City")
    private  String city;


    @Column(name ="state" ,nullable = true)
    private  String State;

    @Column(name="Country")
    private  String country;


}
