/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.Connector;
import main.Movie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Dwika
 */
public class MovieModel {
    Connector con = new Connector();
    
    public void insertMovie(Movie movie){
        String query = "insert into movie(judul,alur,penokohan,akting,nilai) values (?,?,?,?,?)";
        PreparedStatement pstm;
        
        try{
           con.statement = con.koneksi.createStatement();
           pstm = con.koneksi.prepareStatement(query);
           pstm.setString(1, movie.getJudul());
           pstm.setDouble(2, movie.getAlurCerita());
           pstm.setDouble(3, movie.getPenokohan());
           pstm.setDouble(4, movie.getAkting());
           pstm.setDouble(5, movie.getRating());
           pstm.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public ArrayList<Movie> getMovie(){
        String query = "select * from movie";
        PreparedStatement pstm;
        
        try{
           con.statement = con.koneksi.createStatement();
           pstm = con.koneksi.prepareStatement(query);
           ResultSet rs = pstm.executeQuery();
           ArrayList<Movie> list = new ArrayList<>();
           while(rs.next()){
               Movie movie = new Movie();
               movie.setJudul(rs.getString("judul"));
               movie.setAlurCerita(rs.getDouble("alur"));
               movie.setPenokohan(rs.getDouble("penokohan"));
               movie.setAkting(rs.getDouble("akting"));
               movie.setRating(rs.getDouble("Akitng"));
               list.add(movie);
           }
           return list;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void updateMovie(Movie movie){
        String query = "update movie set alur = ?, penokohan = ?, akting = ?, nilai = ? where judul = ?";
        PreparedStatement pstm;
        
        try{
           con.statement = con.koneksi.createStatement();
           pstm = con.koneksi.prepareStatement(query);
           pstm.setDouble(1, movie.getAlurCerita());
           pstm.setDouble(2, movie.getPenokohan());
           pstm.setDouble(3, movie.getAkting());
           pstm.setDouble(4, movie.getRating());
           pstm.setString(5, movie.getJudul());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteMovie(String judul){
        String query = "delete from movie where judul = ?";
        PreparedStatement pstm;
        try {
            pstm = con.koneksi.prepareStatement(query);
            pstm.setString(0, judul);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean isContainMovie(){
        System.out.println("isContainMovie()");
        try{
            String query = "select count(*) as num from movie";
            PreparedStatement ptsm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            rs.next();
            if(rs.getInt("num") > 0) return true;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }
    
}
