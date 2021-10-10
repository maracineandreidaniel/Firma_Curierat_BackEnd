package Controllers;

import Model.Client;
import Model.Curier;
import Model.Livrare;
import Repositories.ClientRepository;
import Repositories.LivrareRepository;

import java.time.LocalDateTime;

public class ClientController {

    private ClientRepository clienti;
    private LivrareRepository livrari;

    public ClientController() {
        clienti = new ClientRepository();
        livrari=new LivrareRepository();
    }

    public void insert(Client client) {
        clienti.insertClient(client);
    }

    public void delete(String nume) {
        clienti.removeClient(nume);
    }

    public void updateNumeClient(String nume, String numeNou) {
        clienti.updateNume(nume, numeNou);
    }

    public void updateParolaClient(String nume, String parola) {
        clienti.updateParola(nume, parola);
    }



}
