package Model;

public class Curier {
    private String nume;
    private String parola;

    public Curier(String nume, String parola){
        this.nume=nume;
        this.parola=parola;
    }



    public Curier(String nume){
        this.nume=nume;
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
        return "Curier{" +
                "nume='" + nume + '\'' +
                ", parola='" + parola + '\'' +
                '}';
    }
}
