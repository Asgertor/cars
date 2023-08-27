package dat3.car.config;

import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeveloperData implements ApplicationRunner {
    CarRepository carRepository;
    MemberRepository memberRepository;
    public DeveloperData(CarRepository carRepository, MemberRepository memberRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford", "Mustang", 250, 25));
        cars.add(new Car("Ford", "Fiesta", 150, 20));
        cars.add(new Car("Ford", "Focus", 200, 22));
        cars.add(new Car("Ford", "Mondeo", 300, 30));
        cars.add(new Car("Ford", "GT", 350, 35));
        cars.add(new Car("Ford", "Ranger", 250, 25));
        cars.add(new Car("Ford", "Explorer", 200, 20));
        cars.add(new Car("Ford", "F-150", 300, 30));
        carRepository.saveAll(cars);

        List<Member> members = new ArrayList<>();
        members.add(new Member("JohnDoe1", "1234", "JohnDoe1@mail.com", "John", "Doe", "Main street", "New York", "12345678"));
        members.add(new Member("JaneSmith1", "5678", "JaneSmith1@mail.com", "Jane", "Smith", "Elm street", "Los Angeles", "87654321"));
        members.add(new Member("MichaelJohnson1", "9012", "MichaelJohnson1@mail.com", "Michael", "Johnson", "Oak street", "Chicago", "23456789"));
        members.add(new Member("EmilyBrown1", "3456", "EmilyBrown1@mail.com", "Emily", "Brown", "Maple street", "Boston", "98765432"));
        members.add(new Member("DavidWilson1", "7890", "DavidWilson1@mail.com", "David", "Wilson", "Cedar street", "San Francisco", "34567890"));
        memberRepository.saveAll(members);

    }
}
