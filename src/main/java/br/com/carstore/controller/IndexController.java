package br.com.carstore.controller;

import br.com.carstore.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class IndexController {

    @GetMapping("/car")
    public ResponseEntity <List<Car>> home() {
        Car car = new Car();
        car.setName("fusca");
        car.setColor("Amarelo");
        
        Car car2 = new Car();
        car2.setName("gol");
        car2.setColor("Preto");

        List<Car> cars = List.of(car, car2);
        return ResponseEntity.ok(cars);
    }
}