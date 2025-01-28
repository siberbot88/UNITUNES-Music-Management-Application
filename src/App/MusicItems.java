//Class MusicItem
package App;
public class MusicItems {
    private String judul;
    private String durasi;
    private int tahun;

    public MusicItems(String judul, String durasi, int tahun){
        this.judul = judul;
        this.durasi = durasi;
        this.tahun = tahun;
    }

    public String getJudul(){
        return this.judul;
    }

    public String getDurasi(){
        return this.durasi;
    }

    public int getTahun(){
        return this.tahun;
    }

    public void displayInfo(){
        System.out.println(this.judul+" \n   "+this.durasi+"\t"+this.tahun);
    }
}
