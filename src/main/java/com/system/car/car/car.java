package com.system.car.car;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.system.car.address.address;
import com.system.car.person.person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="Brand")
    private String brand;

    @Column(name="ModelName")
    private String modelname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="RegisterDate")
    private Date registerdate;

    @Column(name="LicensePlateNumber")
    private String LicensePlateNumber ;

   @ManyToOne
   @JoinColumn(name = "personId", foreignKey = @ForeignKey(name ="Person_id_fk"))

    private person person;

    @ManyToOne
    @JoinColumn(name = "addressid", foreignKey = @ForeignKey(name ="adress_id_fk"))

    private address address;


}
