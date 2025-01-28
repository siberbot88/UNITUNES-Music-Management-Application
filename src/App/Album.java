//Class ALbum
package App;
import java.util.ArrayList;
public class Album {
    private String nama;
    private ArrayList<Songs> lagu;
    private Artist artis;

    public Album(String nama, Artist artis){
        this.nama = nama;
        this.lagu = new ArrayList<>();
        this.artis = artis;
    }

    public void addLagu (Songs baru){
        lagu.add(baru);
    }
    
    public String getNama(){
        return this.nama;
    }

    public Artist getArtis(){
        return this.artis;
    }

    public ArrayList<Songs> getLagu(){
        return this.lagu;
    }

    public void displayInfo(){
        System.out.println("Judul Album : "+this.nama);
        System.out.println("Artis t: "+this.artis);
        System.out.println("Daftar Lagu dalam Album : ");
        for (int i = 0; i < lagu.size(); i++) {
            System.out.println((i+1)+". "+lagu.get(i).getJudul());
        }
        if (lagu.size() ==0) {
            System.out.println("Tidak ada lagu dalam album.");
        }
    }
}
