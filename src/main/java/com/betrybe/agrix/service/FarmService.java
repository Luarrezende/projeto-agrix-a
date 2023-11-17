package com.betrybe.agrix.service;

import com.betrybe.agrix.model.entities.FarmModel;
import com.betrybe.agrix.model.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;

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

  public List<FarmModel> getAll() {
    return farmRepository.findAll();
  }

  // public FarmModel getById(Long id) {
  //   return farmRepository.findById(id)
  //           .orElseThrow(() -> new FarmNotFoundException("Fazenda não encontrada!"));
  // }
}
