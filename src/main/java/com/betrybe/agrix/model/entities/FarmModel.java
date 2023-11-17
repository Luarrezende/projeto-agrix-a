package com.betrybe.agrix.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Model representing a farm.
 */
@Data
@Entity
@Table(name = "farms")
public class FarmModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Double size;

  /**
   * contructor com coisas.
   */
  public FarmModel(Long id, String name, Double size) {
    this.id = id;
    this.name = name;
    this.size = size;
  }

  public FarmModel() {
  }
}
