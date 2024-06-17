package com.StreamFusion.operador_service.controller;

import com.StreamFusion.operador_service.Dto.PurchaseRequest;
import com.StreamFusion.operador_service.Dto.RentRequest;
import com.StreamFusion.operador_service.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @PostMapping("/registerPurchase")
    public String registerPurchase(@RequestBody PurchaseRequest purchaseRequest) {
        boolean isValid = operadorService.validatePurchase(purchaseRequest);

        if (isValid) {
            String result = operadorService.registerPurchase(purchaseRequest);
            return "Purchase registered successfully: " + result;
        } else {
            return "Purchase validation failed";
        }
    }

    @PostMapping("/rentAccount")
    public String rentAccount(@RequestBody RentRequest rentRequest) {
        boolean isValid = operadorService.validateRent(rentRequest);

        if (isValid) {
            String result = operadorService.rentAccount(rentRequest);
            return "Account rented successfully: " + result;
        } else {
            return "Account rental validation failed";
        }
    }
}
