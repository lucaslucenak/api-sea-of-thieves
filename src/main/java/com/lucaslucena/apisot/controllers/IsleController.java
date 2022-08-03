package com.lucaslucena.apisot.controllers;

import com.lucaslucena.apisot.models.IsleModel;
import com.lucaslucena.apisot.services.IsleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/isles")
public class IsleController {

    @Autowired
    private IsleService isleService;
    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IsleModel createIsle(@RequestBody IsleModel isleModel) throws Exception {
        isleModel.setName(isleModel.getName().toUpperCase());
        isleModel.setX_coordinate(isleModel.getX_coordinate().toUpperCase());
        isleModel.setY_coordinate(isleModel.getY_coordinate().toUpperCase());
        isleModel.setDescription(isleModel.getDescription().toUpperCase());
        return isleService.createIsle(isleModel);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IsleModel> findAllIsles() {
        return isleService.findAllIsles();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("{id}")
    public IsleModel findIsleById(@PathVariable("id") Long id) {
        return isleService.findIsleById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Isle not found"));
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/findByName/{name}")
    public IsleModel findIsleByName(@PathVariable("name") String name) {
        IsleModel isleModel = new IsleModel();

        for (IsleModel i : isleService.findAllIsles()) {
            if (i.getName().toUpperCase().equals(name)) {
                isleModel = i;
            }
        }
        return isleService.findIsleById(isleModel.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Isle not found"));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIsleById(@PathVariable("id") Long id) {
        isleService.findIsleById(id)
                .map(isle -> {
                    isleService.deleteIsleById(isle.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Isle not found"));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateIsle(@RequestBody IsleModel isleModel) {
        isleService.findIsleById(isleModel.getId())
                .map(baseIsle -> {
                    modelMapper.map(isleModel, baseIsle);
                    baseIsle.setName(baseIsle.getName().toUpperCase());
                    baseIsle.setX_coordinate(baseIsle.getX_coordinate().toUpperCase());
                    baseIsle.setY_coordinate(baseIsle.getY_coordinate().toUpperCase());
                    baseIsle.setDescription(baseIsle.getDescription().toUpperCase());
                    isleService.createIsle(baseIsle);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Isle not found"));
    }
}