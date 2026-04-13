package com.quiz.quiz_GitierrezR_GonzalezD.service;

import com.quiz.quiz_GitierrezR_GonzalezD.dto.TruckRequest;
import com.quiz.quiz_GitierrezR_GonzalezD.dto.TruckResponse;
import com.quiz.quiz_GitierrezR_GonzalezD.entity.Truck;
import com.quiz.quiz_GitierrezR_GonzalezD.exception.DuplicateResourceException;
import com.quiz.quiz_GitierrezR_GonzalezD.exception.ResourceNotFoundException;
import com.quiz.quiz_GitierrezR_GonzalezD.repository.TruckRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckService {

    private final TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<TruckResponse> getAllTrucks() {
        return truckRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public TruckResponse getTruckById(Long id) {
        Truck truck = truckRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Camión no encontrado con id: " + id));

        return toResponse(truck);
    }

    public TruckResponse createTruck(TruckRequest request) {
        if (truckRepository.existsByPlate(request.getPlate())) {
            throw new DuplicateResourceException("Ya existe un camión con la placa: " + request.getPlate());
        }

        Truck truck = new Truck(
                request.getTrucks(),
                request.getBrand(),
                request.getCapacity(),
                request.getColor(),
                request.getPlate(),
                request.getUserDriver()
        );

        return toResponse(truckRepository.save(truck));
    }

    public TruckResponse updateTruck(Long id, TruckRequest request) {
        Truck truck = truckRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Camión no encontrado con id: " + id));

        if (truckRepository.existsByPlateAndIdNot(request.getPlate(), id)) {
            throw new DuplicateResourceException("Ya existe otro camión con la placa: " + request.getPlate());
        }

        truck.setTrucks(request.getTrucks());
        truck.setBrand(request.getBrand());
        truck.setCapacity(request.getCapacity());
        truck.setColor(request.getColor());
        truck.setPlate(request.getPlate());
        truck.setUserDriver(request.getUserDriver());

        return toResponse(truckRepository.save(truck));
    }

    public void deleteTruck(Long id) {
        Truck truck = truckRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Camión no encontrado con id: " + id));

        truckRepository.delete(truck);
    }

    private TruckResponse toResponse(Truck truck) {
        return new TruckResponse(
                truck.getId(),
                truck.getTrucks(),
                truck.getBrand(),
                truck.getCapacity(),
                truck.getColor(),
                truck.getPlate(),
                truck.getUserDriver()
        );
    }
}
