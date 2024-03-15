package com.babelgroup.service.client;

import com.babelgroup.dtos.ClientDto;
import com.babelgroup.model.Client;
import com.babelgroup.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient (ClientDto clientDetails) {
        Client client = new Client();
        client.setName(clientDetails.getName());
        client.setSurname(clientDetails.getSurname());
        client.setAddress(clientDetails.getAddress());
        clientRepository.save(client);
    }

    @Override
    public void updateClient(ClientDto clientDetails) {
        Client client = clientRepository.findById(clientDetails.getId()).orElseThrow(() -> new RuntimeException("No existe ningún cliente con la ID: " + clientDetails.getId()));
        if (clientDetails.getName() != null) client.setName(clientDetails.getName());
        if (clientDetails.getSurname() != null) client.setSurname(clientDetails.getSurname());
        if (clientDetails.getAddress() != null) client.setAddress(clientDetails.getAddress());
        clientRepository.save(client);
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(client -> new ClientDto(client.getId(), client.getName(), client.getSurname(), client.getAddress(), client.getOrderList())).collect(Collectors.toList());
    }

    @Override
    public ClientDto getClientById(String clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("No existe ningún cliente con la ID: " + clientId));
        return new ClientDto(client.getId(), client.getName(), client.getSurname(), client.getAddress(), client.getOrderList());
    }

    @Override
    public void deleteClient(String clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("No existe ningún cliente con la ID: " + clientId));
        clientRepository.delete(client);
    }
}
