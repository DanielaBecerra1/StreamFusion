package com.StreamFusion.buscador_service.repository;

import com.StreamFusion.buscador_service.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}