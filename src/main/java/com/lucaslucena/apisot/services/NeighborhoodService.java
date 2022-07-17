package com.lucaslucena.apisot.services;

import com.lucaslucena.apisot.models.IsleModel;
import com.lucaslucena.apisot.models.NeighborhoodModel;
import com.lucaslucena.apisot.repositories.IsleRepository;
import com.lucaslucena.apisot.repositories.NeighborhoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;

    public NeighborhoodService(NeighborhoodRepository neighborhoodRepository) {
        this.neighborhoodRepository = neighborhoodRepository;
    }

    public NeighborhoodModel createNeighborhood(NeighborhoodModel isleModel) {
        return neighborhoodRepository.save(isleModel);
    }

    public List<NeighborhoodModel> findAllNeighborhoods() {
        return neighborhoodRepository.findAll();
    }

    public Optional<NeighborhoodModel> findNeighborhoodById(Long id) {
        return neighborhoodRepository.findById(id);
    }

    public void deleteNeighborhoodById(Long id) {
        neighborhoodRepository.deleteById(id);
    }
}
