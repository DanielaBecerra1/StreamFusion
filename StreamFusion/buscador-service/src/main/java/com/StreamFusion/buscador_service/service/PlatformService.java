package com.StreamFusion.buscador_service.service;

import com.StreamFusion.buscador_service.entity.Platform;
import java.util.List;

public interface PlatformService {
    List<Platform> findAllPlatforms();


    Platform savePlatform(Platform platform);
    Platform updatePlatform(long id, Platform platform);
    void deletePlatform(long id);
}