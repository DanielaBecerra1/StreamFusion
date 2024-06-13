package com.StreamFusion.buscador_service.service;

import com.StreamFusion.buscador_service.entity.Platform;
import com.StreamFusion.buscador_service.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        Platform platformDb = platformRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Platform not found with id: " + id));

        if (Objects.nonNull(platform.getCode()) && !platform.getCode().isEmpty()) {
            platformDb.setCode(platform.getCode());
        }

        if (Objects.nonNull(platform.getName()) && !platform.getName().isEmpty()) {
            platformDb.setName(platform.getName());
        }

        if (platform.getPrice() > 0) {
            platformDb.setPrice(platform.getPrice());
        }

        if (Objects.nonNull(platform.getAvailable())) {
            platformDb.setAvailable(platform.getAvailable());
        }

        return platformRepository.save(platformDb);
    }

    @Override
    public void deletePlatform(long id) {
        platformRepository.deleteById(id);
    }
}
