package com.lucaslucena.apisot.services;

import com.lucaslucena.apisot.models.IsleModel;
import com.lucaslucena.apisot.repositories.IsleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IsleService {

    private final IsleRepository isleRepository;

    public IsleService(IsleRepository isleRepository) {
        this.isleRepository = isleRepository;
    }

    public IsleModel createIsle(IsleModel isleModel) {
        return isleRepository.save(isleModel);
    }

    public List<IsleModel> findAllIsles() {
        return isleRepository.findAll();
    }

    public Optional<IsleModel> findIsleById(Long id) {
        return isleRepository.findById(id);
    }

    public void deleteIsleById(Long id) {
        isleRepository.deleteById(id);
    }
}
