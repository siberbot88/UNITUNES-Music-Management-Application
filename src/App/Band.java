//Class Band
package App;
import java.util.ArrayList;
public class Band extends Artist {
    private ArrayList<Artist> anggota = new ArrayList<>();

    public Band (String nama, String genre){
        super(nama, genre);
    }

    public void addAnggota(Artist artis){
        anggota.add(artis);
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Anggota Band:");
        int i = 1;
        for (Artist artis : anggota) {
            System.out.println(i+". " + artis.getNama());
            i++;
        }
    }
}
