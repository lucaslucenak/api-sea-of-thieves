package com.lucaslucena.apisot.controllers;

import com.lucaslucena.apisot.models.NeighborhoodModel;
import com.lucaslucena.apisot.services.IsleService;
import com.lucaslucena.apisot.services.NeighborhoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/neighborhoods")
public class NeighborhoodController {

    @Autowired
    private NeighborhoodService neighborhoodService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NeighborhoodModel createNeighboorhood(@RequestBody NeighborhoodModel neighborhoodModel) {
        neighborhoodModel.setName(neighborhoodModel.getName().toUpperCase());
        return neighborhoodService.createNeighborhood(neighborhoodModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NeighborhoodModel> findAllNeighboorhoods() {
        return neighborhoodService.findAllNeighborhoods();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNeighboorhood(@PathVariable("id") Long id) {
        neighborhoodService.findNeighborhoodById(id)
                .map(neighboorhood -> {
                    neighborhoodService.deleteNeighborhoodById(neighboorhood.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Neighborhood not found"));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNeighborhood(@RequestBody NeighborhoodModel neighborhoodModel) {
        neighborhoodService.findNeighborhoodById(neighborhoodModel.getId())
                .map(baseNeighborhood -> {
                    modelMapper.map(neighborhoodModel, baseNeighborhood);
                    baseNeighborhood.setName(baseNeighborhood.getName().toUpperCase());
                    neighborhoodService.createNeighborhood(baseNeighborhood);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Neighborhood not found"));
    }
}
