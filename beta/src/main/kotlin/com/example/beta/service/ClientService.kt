package com.example.beta.service

import com.example.beta.repository.ClientRepository
import com.example.beta.exception.ClientNotFoundException
import com.example.beta.repository.model.Client
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

/**
 * Service for interactions with employee domain object
 */
@Service
class ClientService(private val clientRepository: ClientRepository) {

    /**
     * Get all Clients list.
     *
     * @return the list
     */
    fun getAllClients(): List<Client> = clientRepository.findAll()

    /**
     * Gets Clients by id.
     *
     * @param clientId the Client id
     * @return the Client by id
     * @throws ClientNotFoundException the Client not found exception
     */
    fun getClientsById(clientId: Long): Client = clientRepository.findById(clientId)
        .orElseThrow { ClientNotFoundException(HttpStatus.NOT_FOUND, "No matching Client was found") }

    /**
     * Create Client.
     *
     * @param Client the Client
     * @return the Client
     */
    fun createClient(client: Client): Client = clientRepository.save(client)

    /**
     * Update client.
     *
     * @param clientId the client id
     * @param client the client details
     * @return the client
     * @throws ClientNotFoundException the client not found exception
     */
    fun updateClientById(clientId: Long, client: Client): Client {
        return if (clientRepository.existsById(clientId)) {
            clientRepository.save(
                Client(
                    id = client.id,
                    name = client.name,
                    phone = client.phone,
                    email = client.email,
                    address = client.address,
                    commentOrPromocode = client.commentOrPromocode
                )
            )
        } else throw ClientNotFoundException(HttpStatus.NOT_FOUND, "No matching Client was found")
    }

    /**
     * Delete client.
     *
     * @param clientId the client id
     * @return the map
     * @throws ClientNotFoundException the client not found exception
     */
    fun deleteClientsById(clientId: Long) {
        return if (clientRepository.existsById(clientId)) {
            clientRepository.deleteById(clientId)
        } else throw ClientNotFoundException(HttpStatus.NOT_FOUND, "No matching client was found")
    }
}