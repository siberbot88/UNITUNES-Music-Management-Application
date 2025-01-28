//Class SongLibrary
package App;
public class PerpustakaanLagu {
    private Songs[] daftarLagu;
    private int totallagu;
    private Node editHead;

    public PerpustakaanLagu(int maxLagu){
        daftarLagu = new Songs[maxLagu];
        totallagu = 0;
        editHead = null;
    }

    public void addLagu (Songs lagu){
        if (totallagu < daftarLagu.length) {
            daftarLagu[totallagu++] = lagu;
            Node newoNode = new Node(lagu);
            newoNode.next = editHead;
            editHead = newoNode;
        }else{
            System.out.println("Perpustakaan sudah penuh, tidak bisa menambahkan lagu");
        }
    }

    public void displayInfo(){
        System.out.println("Daftar lagu : ");
        for (int i = 0; i < totallagu; i++) {
            System.out.println((i+1)+". "+daftarLagu[i].getJudul()+" - "+daftarLagu[i].getArtis());
        }
    }

    public Songs hapus(){
        if (editHead == null) {
            System.out.println("Lagu Kosong.");
            return null;
        }
        Songs PoppedSong = editHead.data;
        editHead = editHead.next;
        return PoppedSong;
    }

}
