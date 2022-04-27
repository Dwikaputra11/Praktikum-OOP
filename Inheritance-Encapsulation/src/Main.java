import animal.Burung;
import animal.Hewan;
import animal.Kucing;
import user.User;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        Hewan nuri = new Burung("Nuri",3,2); // polymorphism
        // method yang digunakan hanya pada kelas hewan saja
        nuri.berjalan();
//        nuri.terbang();
        System.out.println("Nama : " + nuri.getNama());
        Kucing angora = new Kucing("Angora",2,4);
        System.out.println("Nama : " + angora.getNama());
        angora.karnivora();
        angora.berjalan();

//        Scanner input = new Scanner(System.in);
//
//        System.out.print("Masukkan nama: ");
//        String nama = input.next();
//        System.out.println("\nMasukkan passsword: ");
//        String pass = input.next();
//        User user = new User(nama,pass);
//        System.out.println("Berhasil ditambahkan!");
//        new Scanner(System.in).nextLine();
//        System.out.println("Login");
//        System.out.print("User : ");
//        nama = input.next();
//        System.out.print("Password: ");
//        pass = input.next();
//
//        if (user.login(nama,pass)) System.out.println("Login berhasil!");
//        else System.out.println("Maaf email atau password anda salah");
    }
}
