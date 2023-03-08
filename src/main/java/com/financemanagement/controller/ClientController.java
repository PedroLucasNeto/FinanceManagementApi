package com.financemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financemanagement.model.Client;
import com.financemanagement.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@PostMapping
	ResponseEntity<Client> createClient(@RequestBody Client client) {
		boolean success = clientService.createClient(client);
		if (success) {
			return new ResponseEntity<Client>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Client>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping 
	ResponseEntity<Client> deleteClient(@PathVariable Long id) throws Exception {
		clientService.deleteClient(id);
			return new ResponseEntity<Client>(HttpStatus.OK);
	}

	@PutMapping("/{id}") 
	ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) throws Exception {
		clientService.updateClient(id, client);
		return new ResponseEntity<Client>(HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity <Iterable<Client>> listClients(){
		Iterable<Client> listClients = clientService.listClients();
		return new ResponseEntity<Iterable<Client>>(listClients, HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	ResponseEntity<Iterable<Client>> getClientByName(@PathVariable String name){
		List<Client> clients = (List<Client>) clientService.findByName(name);
		if (clients.isEmpty()) {
			return new ResponseEntity<Iterable<Client>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Iterable<Client>>(clients, HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	ResponseEntity<Client> getClientById(@PathVariable Long id) throws Exception{
		Client client = clientService.findById(id);
		if (client.equals(null)) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
}
