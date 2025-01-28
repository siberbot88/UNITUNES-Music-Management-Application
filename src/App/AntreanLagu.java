//Class Antrean Lagu
package App;
public class AntreanLagu {
    private Node front;
    private Node rear;
    private int size;

    public AntreanLagu(){
        front = null;
        rear = null;
        size = 0;
    }

    public void tambahAntrean (Songs lagu){
        Node newMNode = new Node(lagu);
        if (rear != null) {
            rear.next = newMNode;
        }
        rear = newMNode;
        if (front == null) {
            front = newMNode;
        }
        size++;
    }

    public Songs putarAntrean(){
        if (front == null) {
            System.out.println("Antrean Kosong");
            return null;
        }
        Songs removeLagu = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return removeLagu;
    }

    public boolean isEmpty(){
        return front==null;
    }

    public int getSize(){
        return this.size;
    }

    public String toString(){
        return " "+this.front;
    }

    public void displayInfo(){
        Node current = front;
        int i = 1;
        while (current != null){
            System.out.println(i+". "+current.data.getJudul()+" - "+current.data.getArtis());
            i++;
            current = current.next;
        }
    }
    
}