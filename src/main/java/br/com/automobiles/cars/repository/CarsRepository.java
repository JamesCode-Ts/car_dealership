package br.com.automobiles.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.automobiles.cars.model.Cars;

public interface CarsRepository extends JpaRepository<Cars, Long> {

}
