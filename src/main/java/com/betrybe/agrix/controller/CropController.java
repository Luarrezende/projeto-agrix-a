package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropDtos;
import com.betrybe.agrix.model.entities.CropModel;
import com.betrybe.agrix.service.CropService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Crop controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {
  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
  * Get all crops.
  */
  @GetMapping
  public ResponseEntity<List<CropDtos>> getAllCrop() {
    List<CropModel> crops = cropService.getAll();
    List<CropDtos> cropsDto = crops.stream()
        .map(crop -> 
            new CropDtos(
                crop.getId(), crop.getName(), crop.getFarmModel().getId(), crop.getPlantedArea()))
                .toList();

    return ResponseEntity.status(HttpStatus.OK).body(cropsDto);
  }
}
