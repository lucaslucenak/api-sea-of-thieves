package com.lucaslucena.apisot.controllers;

import com.lucaslucena.apisot.models.IsleModel;
import com.lucaslucena.apisot.services.IsleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IsleModel createIsle(@RequestBody IsleModel isleModel) throws Exception {
        return isleService.createIsle(isleModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<IsleModel> findAllIsles() {
        return isleService.findAllIsles();
    }

    @GetMapping("{id}")
    public IsleModel findIsleById(@PathVariable("id") Long id) {
        return isleService.findIsleById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Isle not found"));
    }

    @GetMapping("/findByName/{name}")
    public IsleModel findIsleByName(@PathVariable("name") String name) {
        IsleModel isleModel = new IsleModel();

        for (IsleModel i : isleService.findAllIsles()) {
            if (i.getName().equals(name)) {
                isleModel = i;
            }
        }
        return isleService.findIsleById(isleModel.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Isle not found"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIsleById(@PathVariable("id") Long id) {
        isleService.findIsleById(id)
                .map(isle -> {
                    isleService.deleteIsleById(isle.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Isle not found"));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateIsle(@PathVariable("id") Long id, @RequestBody IsleModel isleModel) {
        isleService.findIsleById(isleModel.getId())
                .map(baseIsle -> {
                    modelMapper.map(isleModel, baseIsle);
                    isleService.createIsle(baseIsle);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Isle not found"));
    }
}