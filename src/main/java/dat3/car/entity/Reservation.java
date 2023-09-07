package dat3.car.entity;

import dat3.car.dto.MemberResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity

public class Reservation extends AdminDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    LocalDate rentalDate;

    @ManyToOne
    Member member;

    @ManyToOne
    Car car;

    public Reservation(LocalDate rentalDate, Member member, Car car) {
        this.rentalDate = rentalDate;
        this.member = member;
        this.car = car;
        car.addReservation(this);
        member.addReservation(this);
    }

}
