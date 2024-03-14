package com.babelgroup.service;

import com.babelgroup.model.Client;
import com.babelgroup.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(String clientId, Client clientDetails) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("No existe ningún cliente con la ID: " + clientId));
        if (clientDetails.getName() != null) client.setName(clientDetails.getName());
        if (clientDetails.getSurname() != null) client.setSurname(clientDetails.getSurname());
        if (clientDetails.getAddress() != null) client.setAddress(clientDetails.getAddress());
        if (clientDetails.getOrderList() != null) client.setOrderList(clientDetails.getOrderList());
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(String clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("No existe ningún cliente con la ID: " + clientId));
    }

    @Override
    public void deleteClient(String clientId) {
        Client client = getClientById(clientId);
        clientRepository.delete(client);
    }
}
