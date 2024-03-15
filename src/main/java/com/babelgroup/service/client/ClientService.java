package com.babelgroup.service.client;

import com.babelgroup.dtos.ClientDto;
import com.babelgroup.model.Client;

import java.util.List;

public interface ClientService {
    void createClient(ClientDto clientDetails);
    void updateClient(ClientDto clientDetails);
    List<ClientDto> getAllClients();
    ClientDto getClientById(String clientId);
    void deleteClient(String clientId);
}
