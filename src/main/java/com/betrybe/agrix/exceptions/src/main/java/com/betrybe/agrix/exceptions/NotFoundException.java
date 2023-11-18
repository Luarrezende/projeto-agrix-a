package com.betrybe.agrix.exceptions.src.main.java.com.betrybe.agrix.exceptions;

/**
 * Resposta para erro.
 */
public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
