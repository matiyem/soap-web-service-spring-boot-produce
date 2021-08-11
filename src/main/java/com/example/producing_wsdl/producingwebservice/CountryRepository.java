package com.example.producing_wsdl.producingwebservice;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import webServiceGenaration.io.spring.guides.gs_producing_web_service.Country;
import webServiceGenaration.io.spring.guides.gs_producing_web_service.Currency;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * created by Atiye Mousavi
 * Date: 8/1/2021
 * Time: 12:37 PM
 */

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData(){
        Country spain=new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(47545458);

        countries.put(spain.getName(),spain);

        Country poland=new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(454545);

        countries.put(poland.getName(),poland);

        Country uk=new Country();
        uk.setName("United kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(6545454);

        countries.put(uk.getName(),uk);
    }
    public Country findCountry(String name){
        Assert.notNull(name,"The country name must not be null");
        return countries.get(name);
    }



}
