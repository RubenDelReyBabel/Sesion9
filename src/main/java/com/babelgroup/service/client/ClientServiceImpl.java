package com.babelgroup.service.client;

import com.babelgroup.dtos.Assembler;
import com.babelgroup.dtos.ClientDto;
import com.babelgroup.model.Client;
import com.babelgroup.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient(ClientDto clientDetails) {
        Client client = new Client();
        client.setName(clientDetails.name);
        client.setSurname(clientDetails.surname);
        client.setAddress(clientDetails.address);
        clientRepository.save(client);
    }

    @Override
    public void updateClient(ClientDto clientDetails) {
        Client client = clientRepository.findById(clientDetails.id).orElseThrow(() -> new RuntimeException("No existe ningún cliente con la ID: " + clientDetails.id));
        if (clientDetails.name != null) client.setName(clientDetails.name);
        if (clientDetails.surname != null) client.setSurname(clientDetails.surname);
        if (clientDetails.address != null) client.setAddress(clientDetails.address);
        clientRepository.save(client);
    }

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(Assembler::toClientDto).toList();
    }

    @Override
    public ClientDto getClientById(String clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("No existe ningún cliente con la ID: " + clientId));
        return Assembler.toClientDto(client);
    }

    @Override
    public void deleteClient(String clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("No existe ningún cliente con la ID: " + clientId));
        clientRepository.delete(client);
    }
}
