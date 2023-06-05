package ru.car.buycar.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.car.buycar.models.Car;
import ru.car.buycar.services.CarService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public  String cars(@RequestParam(value = "search_request", required = false) String key, Model model){
        if (key == null) model.addAttribute("cars", carService.getAll());
        else {
            model.addAttribute("search_request", key);
            model.addAttribute("cars", carService.search(key));
        }
        return "cars";
    }

    @GetMapping("/{id}")
    public String carInfo(@PathVariable("id") Long id, Model model){
        model.addAttribute(carService.getById(id));
        return "car-info";
    }

    @PostMapping
    public String save(@ModelAttribute Car car){
        carService.save(car);
        return "redirect:/";
    }



//    @GetMapping("/search")
//    public String search(@ModelAttribute("search_request") String key, Model model){
//        List<Car> searchResult = carService.search(key);
//        model.addAttribute("search_result",searchResult);
//        return "search_result";
//
//    }
}



























