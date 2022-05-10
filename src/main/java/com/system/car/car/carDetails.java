package com.system.car.car;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.format.datetime.DateFormatterRegistrar;

import java.util.Date;


public interface carDetails {

    public Long getId();


    public String getBrand();
    public String getMODEL_NAME();
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getREGISTER_DATE();
    public String getLICENSE_PLATE_NUMBER();

}
