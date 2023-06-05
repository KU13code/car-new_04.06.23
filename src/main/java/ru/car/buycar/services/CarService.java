package ru.car.buycar.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.car.buycar.models.Car;
import ru.car.buycar.repositories.CarRepository;

import javax.print.DocFlavor;
import javax.swing.*;
import java.util.ArrayList;
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

    public Car getById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public void save(Car car){
        log.info("Saving new {}", car);
        carRepository.save(car);
    }

    public List<Car> search(String key) {
       // log.info("get brand car");
        //return carRepository.findByBrand(key);
        return searchBySerchWord(key, carRepository.findAll());
    }

    private List<Car> searchBySerchWord(String searchWord, List<Car> cars){
        List<Car> searchCars = new ArrayList<>();
        String lowerSearchWord = makeStringToLowerCase(searchWord);
        char[] searchWordToCharArray = lowerSearchWord.toCharArray();
        for (int a = 0; a < cars.size(); a++){
            String lowerCarsBtand = makeStringToLowerCase(cars.get(a).getBrand());
            char[] chars = lowerCarsBtand.toCharArray();
            for (int i = 0; i < chars.length; i++){
                for (int j = 0; j < searchWordToCharArray.length; j++) {
                    try {
                        if (chars[i] == searchWordToCharArray[j]){
                            if (chars[i + 1] == searchWordToCharArray[j + 1]) {
                                if (chars[i + 2] == searchWordToCharArray[j + 2]) {
                                    if (chars[i + 3] == searchWordToCharArray[j + 3]) {
                                        if (!searchCars.contains(cars.get(a))){
                                            searchCars.add(cars.get(a));
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }catch (IndexOutOfBoundsException e){
                        break;
                    }
                }

            }
        }return searchCars;

    }

    private String makeStringToLowerCase(String word){
        String lowerString = "";
        for (int i = 0; i < word.length(); i ++) {
            char c = word.charAt(i);
            lowerString += Character.toLowerCase(c);
        }
        return lowerString;
    }


}
