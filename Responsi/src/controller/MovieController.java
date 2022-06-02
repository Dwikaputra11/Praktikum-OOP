/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import main.Movie;
import model.MovieModel;
import view.MovieView;

/**
 *
 * @author Dwika
 */
public class MovieController {
    private ArrayList<Movie> list;
    public MovieController(MovieView view, MovieModel model){
        
        if(model.isContainMovie()){
            list = model.getMovie();
            String [][] data = convertData(list);
            view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
        }else{
            JOptionPane.showMessageDialog(null, "Movie belum tersedia");
        }
        view.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String judul = view.getJudul();
               double alur = view.getAlur();
               double penokohan = view.getPenokohan();
               double akting = view.getAkting();
               Movie movie = new Movie(judul,alur,penokohan,akting);
               model.insertMovie(movie);
               list = model.getMovie();
               String [][] data = convertData(list);
               view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
            }
        });
        
        view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String judul = view.getJudul();
               double alur = view.getAlur();
               double penokohan = view.getPenokohan();
               double akting = view.getAkting();
               Movie movie = new Movie(judul, alur, penokohan, akting);
               model.updateMovie(movie);
               list = model.getMovie();
               String [][] data = convertData(list);
               view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
            }
        });
        
        view.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = view.getJudul();
                model.deleteMovie(judul);
                list = model.getMovie();
                String [][] data = convertData(list);
                view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
            }
        });
        
        view.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.tfJudul.setText("");
                view.tfAlur.setText("");
                view.tfPenokohan.setText("");
                view.tfAkting.setText("");
            }
        });
    }
    
    private String[][] convertData(ArrayList<Movie> list){
        String[][] data = new String[list.size()][5];
        
        for(int i = 0; i < list.size(); i++){
            data[i][0] = list.get(i).getJudul();
            data[i][1] = String.valueOf(list.get(i).getAlurCerita());
            data[i][2] = String.valueOf(list.get(i).getPenokohan());
            data[i][3] = String.valueOf(list.get(i).getAkting());
            data[i][4] = String.valueOf(list.get(i).getRating());
        }
        
        return data;
    }
}