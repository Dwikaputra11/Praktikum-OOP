package com.tutorial;

public class Lingkaran implements MenghitungBidang{
    private double r;

    public Lingkaran(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double luasBidang() {
        return Math.PI * r * r;
    }

    @Override
    public double kelilingBidang() {
        return 2 * Math.PI * r;
    }
}
