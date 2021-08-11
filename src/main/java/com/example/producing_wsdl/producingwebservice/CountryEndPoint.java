package com.example.producing_wsdl.producingwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import webServiceGenaration.io.spring.guides.gs_producing_web_service.GetCountryRequest;
import webServiceGenaration.io.spring.guides.gs_producing_web_service.GetCountryResponse;


/**
 * created by Atiye Mousavi
 * Date: 8/2/2021
 * Time: 11:31 AM
 */

@Endpoint
public class CountryEndPoint {
    private static final String NAMESPACE_URL="http://spring.io/guides/gs-producing-web-service";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndPoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URL,localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryResponse(@RequestPayload GetCountryRequest request){
        GetCountryResponse response=new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
