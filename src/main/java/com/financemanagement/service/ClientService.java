package com.financemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.financemanagement.model.Client;
import com.financemanagement.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public boolean createClient(Client client) {

		if (client != null) {
			clientRepository.save(client);
			return true;
		}
		return false;
	}

	public void deleteClient(Long id) throws Exception {
		Client deleteClient = clientRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Client with this ID: " + id));
		clientRepository.delete(deleteClient);
	}

	public Client updateClient(Long id, Client client) throws Exception {
		Client updatedClient = clientRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Client with this ID: " + id));
		updatedClient.setFullname(client.getFullname());
		updatedClient.setDateOfBirth(client.getDateOfBirth());
		updatedClient.setPhone(client.getPhone());
		updatedClient.setInstagram(client.getInstagram());
		updatedClient.setEmail(client.getEmail());


		clientRepository.save(updatedClient);
		return updatedClient;
	}

	public Iterable<Client> listClients() {
		Iterable<Client> listClients = clientRepository.findAll();
		return listClients;
	}

	public Iterable<Client> findByName(String fullname) {
		Iterable<Client> clients = clientRepository.findByFullname(fullname);
		return clients;
	}

	public Client findById(Long id) throws Exception {
		Client client = clientRepository.findById(id)
				.orElseThrow(() -> new Exception("We're sorry. We could not find a Client with this ID: " + id));
		return client;
	}

}
