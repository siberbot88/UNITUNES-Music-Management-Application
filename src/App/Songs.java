//Class Songs
package App;
public class Songs extends MusicItems{
    private String artis;

    public Songs(String judul, String durasi, int tahun, String artis){
        super(judul, durasi, tahun);
        this.artis = artis;
    }

    public String getArtis(){
        return this.artis;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("   "+this.artis);
    }
}
