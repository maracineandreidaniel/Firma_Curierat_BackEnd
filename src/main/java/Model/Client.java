package Model;

public class Client {
    private String nume;
    private String parola;


    public Client(String nume, String parola) {
        this.nume = nume;
        this.parola = parola;
    }

    public Client(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}