package animal;

public class Burung extends Hewan{

    public Burung(String nama, int umur, int jmlKaki){
        super(nama, umur, jmlKaki);
    }

    void terbang(){
        System.out.println(getNama() + " bisa terbang!");
    }

    @Override
    public void berjalan() { // polymorphism
        System.out.println("hayooo");
//        super.berjalan();
    }
}
