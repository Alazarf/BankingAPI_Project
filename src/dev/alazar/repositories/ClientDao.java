package dev.alazar.repositories;

import java.util.List;

import dev.alazar.models.Client;

public interface ClientDao {

	public Client createClient(Client c);

	public Client getClient(int id);

	public List<Client> getAllClients();

	public Client updateClient(Client change);

	public Client deleteClient(int id);
}
