package dat3.car.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "car_brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "car_model", length = 60, nullable = false)
    private String model;

    @Column(name = "rental_price_day")
    private double pricePrDay;

    @Column(name = "max_discount")
    private int bestDiscount;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;


    public Car(String brand, String model, double rentalPriceDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePrDay = rentalPriceDay;
        this.bestDiscount = bestDiscount;
    }




}

