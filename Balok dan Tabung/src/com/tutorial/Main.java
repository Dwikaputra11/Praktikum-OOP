package com.tutorial;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static double p,l,t,r;

    public static void main(String[] args) {
        boolean ulang = true;
        int y;
        int menu;
        while (ulang){
            menu = menu();
            switch (menu){
                case 1:
                    balok();
                    System.out.print("Ulangi? (Ya : 1 || Tidak : 0) ?");
                    y = input.nextInt();
                    ulang = (y == 1);
                    break;
                case 2:
                    tabung();
                    System.out.print("Ulangi? (Ya : 1 || Tidak : 0) ?");
                    y = input.nextInt();
                    ulang = (y == 1);
                    break;
                case 0:
                    ulang = false;
                    break;
            }
        }
    }

    public static int menu(){
        System.out.print(
                """
                        ==========
                        MENU UTAMA
                        ==========
                        1. Hitung Balok
                        2. Hitung Tabung
                        0. Exit
                        Pilih:\040
                        """);
        return input.nextInt();
    }

    public static void balok(){
        System.out.print("Input Panjang: " );
        p = input.nextDouble();
        System.out.print("Input Lebar: ");
        l = input.nextDouble();
        System.out.print("Input Tinggi: ");
        t = input.nextDouble();

        Balok balok = new Balok(p,l,t);

        balok.display();
    }

    public static void tabung(){
        System.out.print("Input Jari-Jari: " );
        r = input.nextDouble();
        System.out.print("Input Tinggi: ");
        t = input.nextDouble();

        Tabung tabung = new Tabung(r,t);

        tabung.display();
    }

}
