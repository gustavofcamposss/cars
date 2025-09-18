package br.com.carstore.service;

import br.com.carstore.model.CarDTO;

import java.util.List;

public interface CarService {

    CarDTO save(CarDTO carDTO);
    List<CarDTO> findAll();
    CarDTO update(Long id, CarDTO carDTO);
    void deleteById(Long id);

}