package com.quiz.quiz_GitierrezR_GonzalezD.repository;

import com.quiz.quiz_GitierrezR_GonzalezD.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TruckRepository extends JpaRepository<Truck, Long> {

    Optional<Truck> findByPlate(String plate);

    boolean existsByPlate(String plate);

    boolean existsByPlateAndIdNot(String plate, Long id);
}
