package com.reto2Ciclo4.reto2Ciclo4.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "supplements")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class CleaningProduct {
    @Id
    private Integer reference;
    private String brand;
    private String category;
    private String presentation;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;

}
