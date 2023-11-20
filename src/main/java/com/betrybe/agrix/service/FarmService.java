package com.betrybe.agrix.service;

import com.betrybe.agrix.exceptions.src.main.java.com.betrybe.agrix.exceptions.FarmNotFoundException;
import com.betrybe.agrix.model.entities.CropModel;
import com.betrybe.agrix.model.entities.FarmModel;
import com.betrybe.agrix.model.repositories.CropRepository;
import com.betrybe.agrix.model.repositories.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Farm.
 */
@Service
public class FarmService {
  private FarmRepository farmRepository;
  private CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public FarmModel insertFarm(FarmModel farmModel) {
    return farmRepository.save(farmModel);
  }

  public List<FarmModel> getAll() {
    return farmRepository.findAll();
  }

  public FarmModel getById(Long id) {
    return farmRepository.findById(id)
            .orElseThrow(FarmNotFoundException::new);
  }

  /**
   * cria crop.
   */
  public CropModel createCrop(Long farmId, CropModel cropModel) {
    FarmModel farmModel = getById(farmId);
    
    cropModel.setFarmModel(farmModel);
    CropModel cropCreated = cropRepository.save(cropModel);
    
    farmModel.getCrops().add(cropCreated);
    farmRepository.save(farmModel);

    return cropCreated;
  }
}
