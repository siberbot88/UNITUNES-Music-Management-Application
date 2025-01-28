//Class HistoryMusic
package App;
import java.util.ArrayList;
class HistoryLagu {
    private ArrayList<Songs> riwayat = new ArrayList<>();

    public void push(Songs lagu) {
        riwayat.add(lagu);
    }

    public Songs pop() {
        if (!riwayat.isEmpty()) {
            return riwayat.remove(riwayat.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return riwayat.isEmpty();
    }

    public void displayInfo() {
        for (Songs lagu : riwayat) {
            System.out.println(" - " + lagu.getJudul());
        }
    }
}


