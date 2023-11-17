package com.betrybe.agrix.service;

import com.betrybe.agrix.model.entities.FarmModel;
import com.betrybe.agrix.model.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service Farm.
 */
@Service
public class FarmService {
  private FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public FarmModel insertFarm(FarmModel farmModel) {
    return farmRepository.save(farmModel);
  }
}
