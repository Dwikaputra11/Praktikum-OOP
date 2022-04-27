package com.tutorial;

public class Balok extends PersegiPanjang implements MenghitungRuang{
    private double t;

    public Balok(double p, double l, double t) {
        super(p,l);
        this.t = t;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    @Override
    public double volume() {
        return super.getP()*super.getL()*t;
    }

    @Override
    public double luasPermukaan() {
        return 2 * (super.getP()*super.getL() + super.getP()*t + super.getL()*t);
    }

    public void display(){
        System.out.println("\nLuas persegi panjang = " + luasBidang());
        System.out.println("Keliling persegi panjang = " + kelilingBidang());
        System.out.println("Volume balok = " + volume());
        System.out.println("Luas permukaan balok = " + luasPermukaan());
    }
}
