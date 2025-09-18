package br.com.carstore.service;

import br.com.carstore.model.CarDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService  {

    private List<CarDTO> cars;

    public CarServiceImpl(){
        cars = new ArrayList<>();
    }

    @Override
    public CarDTO save(CarDTO carDTO) {
        // Simula um id
        carDTO.setId((long) (cars.size() + 1));
        cars.add(carDTO);
        return carDTO;
    }

    @Override
    public List<CarDTO> findAll() {
        return new ArrayList<>(cars);
    }

    @Override
    public CarDTO update(Long id, CarDTO carDTO) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getId().equals(id)) {
                carDTO.setId(id);
                cars.set(i, carDTO);
                return carDTO;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

}