package com.babelgroup.service;

import com.babelgroup.model.Client;

import java.util.List;

public interface ClientService {
    Client createClient(Client client);
    Client updateClient(String clientId, Client clientDetails);
    List<Client> getAllClients();
    Client getClientById(String clientId);

    void deleteClient(String clientId);
}
