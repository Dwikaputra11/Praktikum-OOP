package com.tutorial;

public class Tabung extends Lingkaran implements MenghitungRuang{

    private double t;

    public Tabung(double r, double t) {
        super(r);
        this.t = t;
    }

    @Override
    public double luasBidang() {
        return super.luasBidang() * 2;
    }

    @Override
    public double kelilingBidang() {
        return super.kelilingBidang() * t ;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    @Override
    public double volume() {
        return Math.PI * super.getR() * super.getR() * t;
    }

    @Override
    public double luasPermukaan() {
        return luasBidang() + kelilingBidang();
    }

    public void display(){
        System.out.println("\nLuas lingkaran = " + luasBidang());
        System.out.println("Keliling lingkaran = " + kelilingBidang());
        System.out.println("Volume tabung = " + volume());
        System.out.println("Luas permukaan tabung = " + luasPermukaan());
    }
}
