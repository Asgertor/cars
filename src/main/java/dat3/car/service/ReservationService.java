package dat3.car.service;

import dat3.car.dto.ReservationRequest;
import dat3.car.dto.ReservationResponse;
import dat3.car.entity.Car;
import dat3.car.entity.Member;
import dat3.car.entity.Reservation;
import dat3.car.repository.CarRepository;
import dat3.car.repository.MemberRepository;
import dat3.car.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class ReservationService {
    CarRepository carRepository;
    MemberRepository memberRepository;
    ReservationRepository reservationRepository;

    public ReservationService(CarRepository carRepository, MemberRepository memberRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }

    public ReservationResponse reserveCar(ReservationRequest body) {
        if(body.getDate().isBefore(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Date is in the past");
        }
        if (reservationRepository.existsByCar_IdAndRentalDate(body.getCarId(), body.getDate())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car is already reserved for this date");
        }

        Member member = memberRepository.findById(body.getUserName()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member not found"));
        Car car = carRepository.findById(body.getCarId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car not found"));
        Reservation reservation = new Reservation(body.getDate(), member, car);
        reservationRepository.save(reservation);
        return new ReservationResponse(reservation);

    }

}
