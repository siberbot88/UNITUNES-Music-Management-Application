//Class Artist
package App;
public class Artist {
    private String nama;
    private String genre;

    public Artist(String nama, String genre){
        this.nama = nama;
        this.genre = genre;
    }

    public String getNama(){
        return this.nama;        
    }

    public String getGenre(){
        return this.genre;
    }
    public void displayInfo(){
        System.out.println("Artis : "+this.nama+"\ngenre: "+this.genre);
    }
    public String toString(){
        return "Artis : " +nama+ " (Genre : "+genre+")";
    }
}
