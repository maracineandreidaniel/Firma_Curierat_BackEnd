package Repositories;

import Model.Client;
import Model.Curier;
import Model.Livrare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivrareRepository {

    private String jdbcurl = "jdbc:mysql://localhost:3306/firma_curierat_db?autoreconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public LivrareRepository() {
        try {
            this.connection = DriverManager.getConnection(this.jdbcurl, this.user, this.password);
            this.statement = this.connection.createStatement();
        } catch (SQLException var2) {
            System.out.println("eroare de conectare baza de date");
        }

    }

    public void executeStatement(String execute) {
        try {
            this.statement.execute(execute);
        } catch (SQLException var3) {
            System.out.println("Nu am reusit " + execute);
            //var3.printStackTrace();
        }
    }

    public void insertLivrare(Livrare livrare) {
        String insertTo = " ";
        insertTo = insertTo + "insert into livrari (data,client,curier,preluata,livrata) values (";
        insertTo = insertTo + String.format("'%s','%s','%s',%d,%d",livrare.getData(),livrare.getClient().getNume(),livrare.getCurier().getNume(),0,0);
        insertTo = insertTo + ");";
        this.executeStatement(insertTo);
    }


    public void removeLivrare(String nume, String data){
        String removeTo="";
        removeTo+=String.format("%s,%s", "delete from livrari where curier= '"+nume+"' and data='"+data+"';");
        executeStatement(removeTo);

    }

    public void updateData(String nume , String numeNou){
        String update="";
        update+=String.format("update livrari set nume= '%s'", numeNou);
        update+=String.format(" where nume='%s'", nume);
        executeStatement(update);
    }

    public void updateParola(String nume , String parolaNoua){
        String update="";
        update+=String.format("update curieri set parola='%s'", parolaNoua);
        update+=String.format(" where nume='%s'", nume);
        executeStatement(update);
    }

    private ResultSet lista(){
        executeStatement("select * from livrari");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<Livrare> allLivrari(){
        ResultSet set=lista();
        List<Livrare> livrari = new ArrayList<>();
        try {
            while (set.next()){
                livrari.add(new Livrare(set.getString(1),new Client(set.getString(2)),new Curier(set.getString(3)),set.getBoolean(4),set.getBoolean(5)));
            }
        }catch (Exception e){
//            System.out.println("Nu s-a creat lista");
            e.printStackTrace();
            return null;
        }
        return livrari;
    }
}
