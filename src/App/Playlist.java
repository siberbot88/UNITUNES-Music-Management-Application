//Class Playlist
package App;
import java.util.ArrayList;
public class Playlist {
    private String nama;
    private ArrayList<Songs> daftarLagu = new ArrayList<>();

    public Playlist(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void addLagu(Songs lagu) {
        daftarLagu.add(lagu);
    }

    public void displayInfo() {
        System.out.println("Playlist: " + nama);
        System.out.println("Daftar Lagu:");
        int i = 1;
        for (Songs lagu : daftarLagu) {
            System.out.println(i+". " + lagu.getJudul()+" - "+lagu.getArtis());
            i++;
        }
    }
}
