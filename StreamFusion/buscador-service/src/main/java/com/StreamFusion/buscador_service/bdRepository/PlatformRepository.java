package com.StreamFusion.buscador_service.bdRepository;

import com.StreamFusion.buscador_service.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
    @Query("SELECT p FROM Platform p WHERE p.name = :name")
    Optional<Platform> findPlatformByNameWithJPQL(String name);

    Platform findByid(long id);
    List<Platform> findByAvailable(boolean available);
    List<Platform> findByPrice(long price);
    List<Platform> findByNameIgnoreCase(String name);


}