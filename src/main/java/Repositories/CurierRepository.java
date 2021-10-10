package Repositories;

import Model.Curier;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurierRepository {

    private String jdbcurl = "jdbc:mysql://localhost:3306/firma_curierat_db?autoreconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";
    private Connection connection = null;
    private Statement statement = null;

    public CurierRepository() {
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
        }
    }

    public void insertCurier(Curier curier) {
        String insertTo = " ";
        insertTo = insertTo + "insert into curieri (nume,parola) values (";
        insertTo = insertTo + String.format("'%s','%s'",curier.getNume(),curier.getParola());
        insertTo = insertTo + ");";
        this.executeStatement(insertTo);
    }


    public void removeCurier(String nume){
        String removeTo="";
        removeTo+=String.format("%s", "delete from curieri where nume='"+nume+"';");
        executeStatement(removeTo);

    }

    public void updateNume(String nume , String numeNou){
        String update="";
        update+=String.format("update curieri set nume= '%s'", numeNou);
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
        executeStatement("select * from curieri");
        try {
            return statement.getResultSet();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<Curier> allCurieri(){
        ResultSet set=lista();
        List<Curier> curieri = new ArrayList<>();
        try {
            while (set.next()){
                curieri.add(new Curier(set.getString(2),set.getString(3)));
            }
        }catch (Exception e){
//            System.out.println("Nu s-a creat lista");
            e.printStackTrace();
            return null;
        }
        return curieri;
    }
}
