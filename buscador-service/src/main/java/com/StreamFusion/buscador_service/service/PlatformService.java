package com.StreamFusion.buscador_service.service;

import com.StreamFusion.buscador_service.entity.Platform;
import com.StreamFusion.buscador_service.error.PlatformNotFoundException;

import java.util.List;
import java.util.Optional;


public interface PlatformService {
    List<Platform> findAllPlatforms();

    Platform savePlatform(Platform platform);
    Platform updatePlatform(long id, Platform platform);
    void deletePlatform(long id);
    //buscar por los atributos del producto insignia
    List<Platform> findByAvailable(boolean available);

    List<Platform> findByPrice(long price);

    Optional<Platform> findPlatformByNameWithJPQL(String name);
    List<Platform> findByNameIgnoreCase(String name);

    Platform findByid(long id) throws PlatformNotFoundException;


}