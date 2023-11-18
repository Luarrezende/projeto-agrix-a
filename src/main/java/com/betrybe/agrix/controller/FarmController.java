package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.exceptions.src.main.java.com.betrybe.agrix.exceptions.NotFoundException;
import com.betrybe.agrix.model.entities.FarmModel;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Farm.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {
  private final FarmService farmService;
  
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
    * Create Farm.
    */
  @PostMapping()
  public ResponseEntity<FarmModel> insertFarm(@RequestBody FarmDto farmDto) {
    FarmModel newFarm = farmService.insertFarm(farmDto.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }

  @GetMapping
  public ResponseEntity<List<FarmModel>> getAll() {
    List<FarmModel> farms = farmService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(farms);
  }

  /**
    * get farm to id.
    */
  @GetMapping("/{id}")
  public ResponseEntity<FarmModel> getById(Long id) {
    FarmModel farm = farmService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(farm);
  }

  
}
