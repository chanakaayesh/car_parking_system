package com.system.car.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.system.car.address.address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;


    @Column(name="Name")
    private  String name ;

    @Column(name="surname")
    private  String surname;


    @Column(name="Birthdate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

    @OneToMany(targetEntity = address.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="per_id", referencedColumnName = "id")
    private List<address> address = new ArrayList<>();



}
