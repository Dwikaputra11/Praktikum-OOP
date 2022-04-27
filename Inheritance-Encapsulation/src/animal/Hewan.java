package animal;

public class Hewan {
    private String nama;
    private int umur;
    private int jmlKaki;

    public Hewan(String nama,int umur, int jmlKaki){
        this.nama = nama;
        this.umur = umur;
        this.jmlKaki = jmlKaki;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public int getJmlKaki() {
        return jmlKaki;
    }

    public void setJmlKaki(int jmlKaki) {
        this.jmlKaki = jmlKaki;
    }

    public void berjalan(){
        System.out.println(nama + " ini bisa berjalan");
    }
}
