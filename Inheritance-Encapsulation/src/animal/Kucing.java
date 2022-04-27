package animal;

public class Kucing extends Hewan {

    public Kucing(String nama,int umur, int jmlKaki) {
        super(nama, umur, jmlKaki);
    }

    public void karnivora(){
        System.out.println(getNama() + " bisa makan daging");
    }
}
