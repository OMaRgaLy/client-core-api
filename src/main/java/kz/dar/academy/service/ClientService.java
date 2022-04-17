package kz.dar.academy.service;

import kz.dar.academy.model.ClientModel;
import kz.dar.academy.model.ClientRequest;
import kz.dar.academy.model.ClientResponse;

import java.util.List;

public interface ClientService {

    void isWorkingCheck();

    ClientResponse createClient(ClientRequest postRequest);
    ClientResponse updateClient(ClientRequest postRequest);
    List<ClientResponse> getAllClients();
    ClientResponse getClientById(String clientId);
    void deleteClientById(String clientId);
}
