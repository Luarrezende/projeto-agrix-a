package com.betrybe.agrix.controller;

// import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.model.entities.FarmModel;
import com.betrybe.agrix.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<FarmModel> insertFarm(@RequestBody FarmModel farmModel) {
    FarmModel newFarm = farmService.insertFarm(farmModel);
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }
}
