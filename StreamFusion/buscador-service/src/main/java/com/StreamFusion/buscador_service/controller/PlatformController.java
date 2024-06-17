package com.StreamFusion.buscador_service.controller;

import com.StreamFusion.buscador_service.entity.Platform;
import com.StreamFusion.buscador_service.error.PlatformNotFoundException;
import com.StreamFusion.buscador_service.service.PlatformService;
import com.StreamFusion.buscador_service.dto.PurchaseRequest;
import com.StreamFusion.buscador_service.dto.RentRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @GetMapping("/findAllPlatforms")
    public List<Platform> findAllPlatforms() {
        return platformService.findAllPlatforms();
    }

    @GetMapping("/findPlatformByName/{name}")
    public Optional<Platform> findPlatformByNameWithJPQL(@PathVariable String name) {
        return platformService.findPlatformByNameWithJPQL(name);
    }

    @PostMapping("/createPlatform")
    public Platform savePlatform(@Valid @RequestBody Platform platform) {
        return platformService.savePlatform(platform);
    }

    @PutMapping("/updatePlatform/{id}")
    public Platform updatePlatform(@PathVariable Long id, @RequestBody Platform platform){
        return platformService.updatePlatform(id, platform);
    }

    @DeleteMapping("/deletePlatform/{id}")
    public String deletePlatform(@PathVariable Long id){
        platformService.deletePlatform(id);
        return "Plataforma eliminada satisfactoriamente";
    }

    //buscar por los atributos del producto insignia

    @GetMapping("/findByAvailable/{available}")
    public List<Platform> findByAvailable(@PathVariable boolean available) {
        return platformService.findByAvailable(available);
    }

    @GetMapping("/findByPrice/{price}")
    public List<Platform> findByPrice(@PathVariable long price) {
        return platformService.findByPrice(price);
    }

    @GetMapping("/findByNameIgnoreCase/{name}")
    public List<Platform> findByNameIgnoreCase(@PathVariable String name){
        return platformService.findByNameIgnoreCase(name);
    }

    @GetMapping("/findByid/{id}")
    public Platform findByid(@PathVariable int id) throws PlatformNotFoundException {
        return platformService.findByid(id);
    }

    @PostMapping("/registerPurchase")
    public String registerPurchase(@RequestBody PurchaseRequest purchaseRequest) {
        try {
            Platform platform = platformService.findByid(purchaseRequest.getId());

            if (platform != null) {
                return "Compra registrada satisfactoriamente";
            } else {
                return "Plataforma no encontrada";
            }
        } catch (PlatformNotFoundException e) {
            return "Plataforma no encontrada";
        }
    }

    @PostMapping("/rentAccount")
    public String rentAccount(@RequestBody RentRequest rentRequest) {
        try {
            Platform platform = platformService.findByid(rentRequest.getId());

            if (platform != null) {
                return "Cuenta Rentada satisfactoriamente";
            } else {
                return "Plataforma no encontrada";
            }
        } catch (PlatformNotFoundException e) {
            return "Plataforma no encontrada";
        }
    }

}
