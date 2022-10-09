package br.com.jessicabpetersen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jessicabpetersen.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
