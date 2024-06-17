package com.StreamFusion.operador_service.service;

import com.StreamFusion.operador_service.Dto.PurchaseRequest;
import com.StreamFusion.operador_service.Dto.RentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OperadorService {
    @Autowired
    private RestTemplate restTemplate;

    public boolean validatePurchase(PurchaseRequest purchaseRequest) {
        String url = "http://localhost:8080/findByid/" + purchaseRequest.getId();
        try {
            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateRent(RentRequest rentRequest) {
        String url = "http://localhost:8080/findByid/" + rentRequest.getId();
        try {
            restTemplate.getForObject(url, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String registerPurchase(PurchaseRequest purchaseRequest) {
        String url = "http://localhost:8080/registerPurchase";
        return restTemplate.postForObject(url, purchaseRequest, String.class);
    }

    public String rentAccount(RentRequest rentRequest) {
        String url = "http://localhost:8080/rentAccount";
        return restTemplate.postForObject(url, rentRequest, String.class);
    }
}
