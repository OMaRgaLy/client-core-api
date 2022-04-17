package kz.dar.academy.service;

import kz.dar.academy.model.ClientRequest;
import kz.dar.academy.model.ClientResponse;
import kz.dar.academy.repository.ClientEntity;
import kz.dar.academy.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public void isWorkingCheck() {
        System.out.print("");
    }

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        clientRequest.setClientId(UUID.randomUUID().toString());

        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
        clientEntity = clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public ClientResponse updateClient(ClientRequest clientRequest) {
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);

        ClientEntity dbEntity = clientRepository.getClientEntityByClientId(clientRequest.getClientId());
        clientEntity.setId(dbEntity.getId());

        clientEntity = clientRepository.save(clientEntity);

        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        return clientRepository.getClientEntitiesBy().stream()
                .map(post -> modelMapper.map(post, ClientResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientResponse getClientById(String clientId) {
        ClientEntity clientEntity = clientRepository.getClientEntityByClientId(clientId);
        return modelMapper.map(clientEntity, ClientResponse.class);
    }


    @Override
    public void deleteClientById(String clientId) {
        clientRepository.deleteClientEntitiesByClientId(clientId);
    }
}
