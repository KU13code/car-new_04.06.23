package ru.car.buycar.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.car.buycar.models.Car;
import ru.car.buycar.repositories.CarRepository;

import javax.swing.*;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getAll(){
        log.info("Get all Car");
        return carRepository.findAll();
    }

    public void save(Car car){
        log.info("Saving new {}", car);
        carRepository.save(car);
    }

    public List<Car> search(String key) {
        List<Car> cars = carRepository.findByBrand(key);
        return cars;
    }

}
