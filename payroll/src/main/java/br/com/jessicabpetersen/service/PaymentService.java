package br.com.jessicabpetersen.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.jessicabpetersen.feign.WorkerFeignClient;
import br.com.jessicabpetersen.model.Payment;
import br.com.jessicabpetersen.model.Worker;

@Service
public class PaymentService {
	
	@Value("${ms-worker.host}")
	private String hostWorker;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient client;
	

	public Payment getPaymentRestTemplate(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId+"");
		String url = hostWorker+"/workers/{id}";
		Worker worker = restTemplate.getForObject(url, Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = client.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
	
}
