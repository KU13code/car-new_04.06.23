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
    public  String cars(Model model){
        model.addAttribute("cars", carService.getAll());
        return "cars";
    }

    @PostMapping
    public String save(@ModelAttribute Car car){
        carService.save(car);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("search_request") String key, Model model){
        List<Car> searchResult = carService.search(key);
        model.addAttribute("search_result",searchResult);
        return "search_result";

    }
}



























