package com.StreamFusion.buscador_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="platforms")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Platform{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "Por favor agregue el nombre de la plataforma ")
    private String name;
    private boolean available;
    private int price;



    public boolean getAvailable() {
        return this.available;
    }
}

