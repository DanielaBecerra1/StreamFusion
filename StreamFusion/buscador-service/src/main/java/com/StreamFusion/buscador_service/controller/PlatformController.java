package com.StreamFusion.buscador_service.controller;

import com.StreamFusion.buscador_service.entity.Platform;
import com.StreamFusion.buscador_service.service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platforms")
public class PlatformController {

    @Autowired
    private PlatformService platformService;

    @GetMapping
    public List<Platform> findAllPlatforms() {
        return platformService.findAllPlatforms();
    }

    @PostMapping
    public Platform savePlatform(@RequestBody Platform platform) {
        return platformService.savePlatform(platform);
    }

    @PutMapping("/{id}")
    public Platform updatePlatform(@PathVariable long id, @RequestBody Platform platform) {
        return platformService.updatePlatform(id, platform);
    }

    @DeleteMapping("/{id}")
    public void deletePlatform(@PathVariable long id) {
        platformService.deletePlatform(id);
    }
}
