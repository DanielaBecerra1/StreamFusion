package com.StreamFusion.buscador_service.service;

import com.StreamFusion.buscador_service.bdRepository.PlatformRepository;
import com.StreamFusion.buscador_service.entity.Platform;
import com.StreamFusion.buscador_service.error.PlatformNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformServiceImplementation implements PlatformService {
    @Autowired
    private PlatformRepository platformRepository;

    @Override
    public List<Platform> findAllPlatforms() {
        return platformRepository.findAll();
    }

    @Override
    public Platform savePlatform(Platform platform) {
        return platformRepository.save(platform);
    }

    @Override
    public Platform updatePlatform(long id, Platform platform) {
        Platform platformDb = platformRepository.findById(id).orElse(null);
        if (platformDb != null) {
            if (platform.getName() != null && !platform.getName().isEmpty()) {
                platformDb.setName(platform.getName());
            }
            if (platform.getPrice() != 0) {
                platformDb.setPrice(platform.getPrice());
            }

            platformDb.setAvailable(platform.getAvailable());

            return platformRepository.save(platformDb);
        } else {
            throw new RuntimeException("Platform not found with id: " + id);
        }
    }


    @Override
    public void deletePlatform(long id) {
        platformRepository.deleteById(id);
    }

    //fltrar por los atributos
    @Override
    public List<Platform> findByAvailable(boolean available) {
        return platformRepository.findByAvailable(available);
    }

    @Override
    public List<Platform> findByPrice(long price) {
        return platformRepository.findByPrice(price);
    }

    @Override
    public Optional<Platform> findPlatformByNameWithJPQL(String name){
        return platformRepository.findPlatformByNameWithJPQL(name);
    }

    @Override
    public List<Platform> findByNameIgnoreCase(String name){
        return platformRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Platform findByid(long id) throws PlatformNotFoundException {
        Optional<Platform> platform= platformRepository.findById(id);
        if(!platform.isPresent()){
            throw new PlatformNotFoundException("la Plataforma no esta disponible");
        }
        return platform.get();
    }





}
