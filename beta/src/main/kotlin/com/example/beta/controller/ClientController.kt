package com.example.beta.controller

import com.example.beta.service.ClientService
import com.example.beta.repository.model.Client
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody

/**
 * Controller for REST API endpoints
 */
@RestController
class ClientController(private val clientService: ClientService) {

    @GetMapping("/clients")
    fun getAllClients(): List<Client> = clientService.getAllClients()

    @GetMapping("/clients/{id}")
    fun getClientsById(@PathVariable("id") clientId: Long): Client =
        clientService.getClientsById(clientId)

    @PostMapping("/clients")
    fun createClient(@RequestBody payload: Client): Client = clientService.createClient(payload)

    @PutMapping("/clients/{id}")
    fun updateClientById(@PathVariable("id") clientId: Long, @RequestBody payload: Client): Client =
        clientService.updateClientById(clientId, payload)

    @DeleteMapping("/clients/{id}")
    fun deleteClientsById(@PathVariable("id") employeeId: Long): Unit =
        clientService.deleteClientsById(employeeId)
}