package dat3.car.repository;

import dat3.car.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {
    @Autowired
    CarRepository carRepository;
    Boolean isInitialized = false;

    @BeforeEach
    void setUp() {
        if(!isInitialized){
            carRepository.save(new Car("Ford", "Mustang", 250, 25));
            carRepository.save(new Car("Ford", "Fiesta", 150, 20));
            carRepository.save(new Car("Ford", "Focus", 200, 22));
            carRepository.save(new Car("Ford", "Mondeo", 300, 30));
            carRepository.save(new Car("Ford", "GT", 350, 35));
            carRepository.save(new Car("Ford", "Ranger", 250, 25));
            carRepository.save(new Car("Ford", "Explorer", 200, 20));
            carRepository.save(new Car("Ford", "F-150", 300, 30));
            isInitialized = true;
        }
    }

    @Test
    public void deleteAll(){
        carRepository.deleteAll();
        Long count = carRepository.count();
        assertEquals(0,count);
    }
}