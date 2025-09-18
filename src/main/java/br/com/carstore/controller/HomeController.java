package br.com.carstore.controller;
import br.com.carstore.model.CarDTO;
import br.com.carstore.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @GetMapping("/index")
    public String indexTwo(Model model) {
        model.addAttribute("carDTO", new CarDTO());
        return "index";
    }

    @GetMapping("/cars/edit/{id}")
    public String editCar(@PathVariable Long id, Model model) {
        CarDTO car = null;
        for (CarDTO c : carService.findAll()) {
            if (c.getId().equals(id)) {
                car = c;
                break;
            }
        }
        if (car == null) {
            // Se não encontrar, volta para dashboard
            List<CarDTO> cars = carService.findAll();
            model.addAttribute("cars", cars);
            return "dashboard";
        }
        model.addAttribute("carDTO", car);
        return "index";
    }

    @PostMapping("/cars")
    public String createOrUpdateCar(@ModelAttribute CarDTO car, Model model) {
        if (car.getId() != null && car.getId() > 0) {
            carService.update(car.getId(), car);
        } else {
            carService.save(car);
        }
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "dashboard";
    }

    @PostMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable Long id, Model model) {
        carService.deleteById(id);
        List<CarDTO> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "dashboard";
    }

    @GetMapping("/cars")
    public String getAllCars(Model model) {

        List<CarDTO> cars = carService.findAll();

        model.addAttribute("cars", cars);

        return "dashboard";

    }


}