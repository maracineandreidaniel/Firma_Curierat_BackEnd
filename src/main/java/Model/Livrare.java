package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Livrare {

    private int id;
    private Curier curier;
    private Client client;
    private boolean livrata;
    private boolean preluata;
    private LocalDateTime data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curier getCurier() {
        return curier;
    }

    public void setCurier(Curier curier) {
        this.curier = curier;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isLivrata() {
        return livrata;
    }

    public void setLivrata(boolean livrata) {
        this.livrata = livrata;
    }

    public boolean isPreluata() {
        return preluata;
    }

    public void setPreluata(boolean preluata) {
        this.preluata = preluata;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Livrare(String data, Client client, Curier curier, boolean preluata, boolean livrata){
        this.data=convertStringLocalDateTime(data);
        this.curier=curier;
        this.client=client;
        this.preluata=preluata;
        this.livrata=livrata;
    }

    @Override
    public String toString(){
        String text="";
        DateTimeFormatter format=DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm:ss a");
        text+="Livrarea " + " de la ora "+data.format(format);
        text+=" este livrata de " + curier.getNume()+" catre clientul " + client.getNume();
        return text;
    }








    public static String convertLDTtoStringTFormat(LocalDateTime ldt){
        return String.format("%s",ldt);
    }

    public static String parameterStringConvert(String data){
        String dataF="";
        String[] p1=data.split("T");
        String[] p2=p1[0].split("-");
        String[] p3=p1[1].split(":");
        dataF+=p2[2]+","+p2[1]+","+p2[0]+","+p3[0]+","+p3[1];
        return dataF;
    }

    public static LocalDateTime convertStringLocalDateTime(String data){
        int ddi = Integer.parseInt(data.split(",")[0]);
        int mmi = Integer.parseInt(data.split(",")[1]);
        int yyi = Integer.parseInt(data.split(",")[2]);
        int hhi = Integer.parseInt(data.split(",")[3]);
        int mini = Integer.parseInt(data.split(",")[4]);
        return LocalDateTime.of(yyi, mmi, ddi, hhi, mini);
    }


}
