package kz.dar.academy.controller;

import kz.dar.academy.model.ClientRequest;
import kz.dar.academy.model.ClientResponse;
import kz.dar.academy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    Environment env;

    @GetMapping("/check")
    public ResponseEntity<String> isWorkingCheck() {
        clientService.isWorkingCheck();
        return new ResponseEntity<String>("client-core-api is working at the port " + env.getProperty("local.server.port"), HttpStatus.OK);
    }

    @PostMapping
    public ClientResponse createClient(@Valid @RequestBody ClientRequest postRequest) {
        return clientService.createClient(postRequest);
    }

    @PutMapping
    public ClientResponse updateClient(@Valid @RequestParam ClientRequest postRequest) {
        return clientService.updateClient(postRequest);
    }

    @GetMapping("/all")
    public List<ClientResponse> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping()
    public ClientResponse getClientById(@RequestParam String clientId) {
        return clientService.getClientById(clientId);
    }

    @DeleteMapping()
    public void deleteClientById(@RequestParam String clientId) {
        clientService.deleteClientById(clientId);
    }
}
