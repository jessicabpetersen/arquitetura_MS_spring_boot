package br.com.jessicabpetersen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jessicabpetersen.model.Worker;
import br.com.jessicabpetersen.service.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerController {
	
	@Autowired
	private WorkerService service;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Worker> save(@RequestBody Worker worker){
		return ResponseEntity.ok(service.save(worker));
	}
	
	@PutMapping
	public ResponseEntity<Worker> update(@RequestBody Worker worker){
		return ResponseEntity.ok(service.update(worker));
	}

}
