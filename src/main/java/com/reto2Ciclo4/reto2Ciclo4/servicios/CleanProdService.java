package com.reto2Ciclo4.reto2Ciclo4.servicios;

import com.reto2Ciclo4.reto2Ciclo4.modelo.CleaningProduct;
import com.reto2Ciclo4.reto2Ciclo4.repositorio.CleanProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleanProdService {
    @Autowired
    private CleanProdRepository cleanProdRepository;

    /**
     * Metodo Get
     * @return cleanProdRepository.getAll();
     */
    public List<CleaningProduct> getAll() {
        return cleanProdRepository.getAll();
    }

    public Optional<CleaningProduct> getCleaningProduct(int id) {
        return cleanProdRepository.getCleaningProduct(id);
    }

    /**
     * Metodo Post
     * @param cleaningProduct
     * @return cleanProdRepository.save(cleaningProduct)
     */
    public CleaningProduct save(CleaningProduct cleaningProduct) {
        if (cleaningProduct.getId() == null) {
            return cleaningProduct;
        }
        return cleanProdRepository.save(cleaningProduct);
    }

    /**
     * Metodo Put
     * @param cleaningProduct
     * @return cleaningProduct
     */
    public CleaningProduct update(CleaningProduct cleaningProduct) {
        if (cleaningProduct.getId() != null) {
            Optional<CleaningProduct> dbProduct = cleanProdRepository.getCleaningProduct(cleaningProduct.getId());

            if (!dbProduct.isEmpty()) {
                if (cleaningProduct.getBrand() != null) {
                    dbProduct.get().setBrand(cleaningProduct.getBrand());
                }

                if (cleaningProduct.getCategory() != null) {
                    dbProduct.get().setCategory(cleaningProduct.getCategory());
                }

                if (cleaningProduct.getPresentation() != null) {
                    dbProduct.get().setPresentation(cleaningProduct.getPresentation());
                }

                if (cleaningProduct.getDescription() != null) {
                    dbProduct.get().setDescription(cleaningProduct.getDescription());
                }

                if (cleaningProduct.getPrice() != 0.0) {
                    dbProduct.get().setPrice(cleaningProduct.getPrice());
                }

                dbProduct.get().setAvailability(cleaningProduct.isAvailability());

                if (cleaningProduct.getQuantity() != 0) {
                    dbProduct.get().setQuantity(cleaningProduct.getQuantity());
                }

                if (cleaningProduct.getPhotography() != null) {
                    dbProduct.get().setPhotography(cleaningProduct.getPhotography());
                }

                cleanProdRepository.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return cleaningProduct;
            }
        } else {
            return cleaningProduct;
        }
    }

    /**
     * Metodo Delete
     * @param id
     * @return true || false
     */
    public boolean delete(int id) {
        return getCleaningProduct(id).map(cleaningProduct -> {
            cleanProdRepository.delete(cleaningProduct);
            return true;
        }).orElse(false);
    }
    public List<CleaningProduct> productsByPrice(double precio){
        return cleanProdRepository.productsByPrice(precio);
    }

    //Reto 5
    public List<CleaningProduct> findByDescriptionLike(String description) {
        return cleanProdRepository.findByDescriptionLike(description);
    }
}
