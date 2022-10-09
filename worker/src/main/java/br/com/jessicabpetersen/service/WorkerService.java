package br.com.jessicabpetersen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jessicabpetersen.model.Worker;
import br.com.jessicabpetersen.repository.WorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository repository;

	public List<Worker> findAll() {
		return repository.findAll();
	}

	public Worker findById(Long id) {
		return repository.findById(id).orElseThrow();
	}

	public Worker save(Worker worker) {
		return repository.save(worker);
	}

	public Worker update(Worker worker) {
		Worker workerU = this.findById(worker.getId());
		validaDados(worker, workerU);
		return repository.save(workerU);
		
	}

	private void validaDados(Worker workerBanco, Worker workerUpdate) {
		if(workerUpdate.getDailyIncome() != null) {
			workerBanco.setDailyIncome(workerBanco.getDailyIncome());
		}
		if(workerUpdate.getName() != null) {
			workerBanco.setName(workerBanco.getName());
		}
	}

}
