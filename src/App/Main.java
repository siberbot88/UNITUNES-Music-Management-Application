//Class Main
package App;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<Songs> perpustakaanLagu = new ArrayList<>();
    private static ArrayList<Album> perpustakaanAlbum = new ArrayList<>();
    private static ArrayList<Artist> perpustakaanArtis = new ArrayList<>();
    private static ArrayList<Band> perpustakaanBand = new ArrayList<>();
    private static ArrayList<Playlist> perpustakaanPlaylist = new ArrayList<>();
    private static AntreanLagu antrean = new AntreanLagu();
    private static HistoryLagu riwayat = new HistoryLagu();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n===== Welcome to uniTunes =====");
            System.out.println("1. Studio Musik");
            System.out.println("2. Cari Musik");
            System.out.println("3. Antrean Musik");
            System.out.println("4. Riwayat Musik");
            System.out.println("5. Perpustakaan Lagu");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi baris baru

            switch (pilihan) {
                case 1:
                    menuStudioMusik(scanner);
                    break;
                case 2:
                    menuCariMusik(scanner);
                    break;
                case 3:
                    menuAntreanMusik(scanner);
                    break;
                case 4:
                    tampilkanRiwayatMusik(scanner);
                    break;
                case 5:
                    menuPerpustakaanLagu(scanner);
                    break;
                case 6:
                    berjalan = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }

    // <Method Tambahan untuk memasukkan data>

    // kumpulan method untuk pencarian data
    private static Songs cariLaguDenganJudul(String judul) {
        for (Songs lagu : perpustakaanLagu) {
            if (lagu.getJudul().equalsIgnoreCase(judul)) {
                return lagu;
            }
        }
        return null;
    }

    private static Album cariAlbumDenganNama(String nama) {
        for (Album album : perpustakaanAlbum) {
            if (album.getNama().equalsIgnoreCase(nama)) {
                return album;
            }
        }
        return null;
    }

    private static Artist cariArtisDenganNama(String nama) {
        for (Artist artis : perpustakaanArtis) {
            if (artis.getNama().equalsIgnoreCase(nama)) {
                return artis;
            }
        }
        return null;
    }

    private static Playlist cariPlaylistDenganNama(String nama) {
        for (Playlist playlist : perpustakaanPlaylist) {
            if (playlist.getNama().equalsIgnoreCase(nama)) {
                return playlist;
            }
        }
        return null;
    }

    private static Band cariBandDenganNama(String nama) {
        for (Band band : perpustakaanBand) {
            if (band.getNama().equalsIgnoreCase(nama)) {
                return band;
            }
        }
        return null;
    }

    // mwthod untuk menu studio musik
    private static void menuStudioMusik(Scanner scanner) {
        boolean runner = true;
        while (runner) {
            System.out.println("\n--- Studio Musik ---");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Tambah Artis");
            System.out.println("3. Tambah Album");
            System.out.println("4. Tambah Band");
            System.out.println("5. Tambah Playlist");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi baris baru

            switch (pilihan) {
                case 1:
                    tambahLagu(scanner);
                    break;
                case 2:
                    tambahArtis(scanner);
                    break;
                case 3:
                    tambahAlbum(scanner);
                    break;
                case 4:
                    tambahBand(scanner);
                    break;
                case 5:
                    tambahPlaylist(scanner);
                    break;
                case 6:
                    runner = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    /**
     * Bagian Method menu tambah
     * 
     */

    // tambah lagu
    private static void tambahLagu(Scanner scanner) {
        System.out.print("Masukkan judul lagu: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan durasi lagu: ");
        String durasi = scanner.nextLine();
        System.out.print("Masukkan tahun lagu: ");
        int tahun = scanner.nextInt();
        scanner.nextLine(); // Mengkonsumsi baris baru
        System.out.print("Masukkan artis: ");
        String artis = scanner.nextLine();

        Songs laguBaru = new Songs(judul, durasi, tahun, artis);
        perpustakaanLagu.add(laguBaru);
        System.out.println("Lagu ditambahkan ke perpustakaan.");
    }

    private static void tambahLaguKeAlbum(Scanner scanner, Album album) {
        System.out.print("Masukkan judul lagu: ");
        String judul = scanner.nextLine();

        Songs lagu = cariLaguDenganJudul(judul);
        if (lagu == null) {
            System.out.println("Lagu tidak ditemukan di perpustakaan. Menambahkan lagu baru.");
            System.out.print("\nMasukkan durasi lagu: ");
            String durasi = scanner.nextLine();
            System.out.print("Masukkan tahun lagu: ");
            int tahun = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi baris baru
            System.out.print("Masukkan artis: ");
            String artis = scanner.nextLine();

            Songs newLagu = new Songs(judul, durasi, tahun, artis);
            lagu = new Songs(judul, durasi, tahun, artis);
            perpustakaanLagu.add(newLagu);
            perpustakaanLagu.add(lagu);
        }

        album.addLagu(lagu);
        System.out.println("Lagu ditambahkan ke album.");
    }

    // tambah Album
    private static void tambahAlbum(Scanner scanner) {
        System.out.print("Masukkan nama album: ");
        String namaAlbum = scanner.nextLine();
        System.out.print("Masukkan nama artis: ");
        String namaArtis = scanner.nextLine();

        Artist artis = cariArtisDenganNama(namaArtis);
        if (artis == null) {
            System.out.println("Artis tidak ditemukan. Menambahkan artis baru.");
            artis = new Artist(namaArtis, "Genre Tidak Diketahui");
            perpustakaanArtis.add(artis);
        }

        Album albumBaru = new Album(namaAlbum, artis);
        perpustakaanAlbum.add(albumBaru);

        System.out.print("\nApakah Anda ingin menambahkan lagu ke album? (ya/tidak): ");
        String jawaban = scanner.nextLine();
        while (jawaban.equalsIgnoreCase("ya")) {
            tambahLaguKeAlbum(scanner, albumBaru);
            System.out.print("\nApakah Anda ingin menambahkan lagu lagi? (ya/tidak): ");
            jawaban = scanner.nextLine();
        }

        System.out.println("Album ditambahkan ke perpustakaan.");
    }

    // tambah artis
    private static void tambahArtis(Scanner scanner) {
        System.out.print("Masukkan nama artis: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan genre artis: ");
        String genre = scanner.nextLine();

        Artist artisBaru = new Artist(nama, genre);
        perpustakaanArtis.add(artisBaru);
        System.out.println("Artis ditambahkan ke perpustakaan.");
    }

    // tambah band
    private static void tambahBand(Scanner scanner) {
        System.out.print("Masukkan nama band: ");
        String namaBand = scanner.nextLine();
        System.out.print("Masukkan genre band: ");
        String genre = scanner.nextLine();

        Band band = new Band(namaBand, genre);

        while (true) {
            System.out.print("Masukkan nama artis untuk ditambahkan ke band (atau ketik 'selesai' untuk selesai): ");
            String namaArtis = scanner.nextLine();
            if (namaArtis.equalsIgnoreCase("selesai")) {
                break;
            }
            Artist artis = cariArtisDenganNama(namaArtis);
            if (artis != null) {
                band.addAnggota(artis);
                System.out.println("Artis " + namaArtis + " ditambahkan ke band.");
            } else {
                System.out.println("Artis tidak ditemukan.");
            }
        }

        perpustakaanBand.add(band);
        System.out.println("Band berhasil ditambahkan.");
    }

    // tambah playlist
    private static void tambahLaguKePlaylist(Scanner scanner, Playlist playlist) {
        System.out.print("Masukkan judul lagu: ");
        String judul = scanner.nextLine();

        Songs lagu = cariLaguDenganJudul(judul);
        if (lagu == null) {
            System.out.println("Lagu tidak ditemukan di perpustakaan. Menambahkan lagu baru.");
            System.out.print("Masukkan durasi lagu: ");
            String durasi = scanner.nextLine();
            System.out.print("Masukkan tahun lagu: ");
            int tahun = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi baris baru
            System.out.print("Masukkan artis: ");
            String artis = scanner.nextLine();

            Songs newLagu = new Songs(judul, durasi, tahun, artis);
            lagu = newLagu;
            perpustakaanLagu.add(newLagu);
        }

        playlist.addLagu(lagu);
        System.out.println("Lagu ditambahkan ke playlist.");
    }

    private static void tambahPlaylist(Scanner scanner) {
        System.out.print("Masukkan nama playlist: ");
        String nama = scanner.nextLine();

        Playlist playlistBaru = new Playlist(nama);
        perpustakaanPlaylist.add(playlistBaru);

        System.out.print("Apakah Anda ingin menambahkan lagu ke playlist? (ya/tidak): ");
        String jawaban = scanner.nextLine();
        while (jawaban.equalsIgnoreCase("ya")) {
            tambahLaguKePlaylist(scanner, playlistBaru);
            System.out.print("Apakah Anda ingin menambahkan lagu lagi? (ya/tidak): ");
            jawaban = scanner.nextLine();
        }

        System.out.println("Playlist ditambahkan ke perpustakaan.");
    }

    // mmethod untuk menu Cari Musik
    private static void menuCariMusik(Scanner scanner) {
        boolean iya = true;
        while (iya) {
            System.out.println("\n--- Cari Musik ---");
            System.out.println("1. Cari Lagu");
            System.out.println("2. Cari Album");
            System.out.println("3. Cari Artis");
            System.out.println("4. Cari Band");
            System.out.println("5. Cari Playlist");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi baris baru

            switch (pilihan) {
                case 1:
                    cariLagu(scanner);
                    break;
                case 2:
                    cariAlbum(scanner);
                    break;
                case 3:
                    cariArtis(scanner);
                    break;
                case 4:
                    cariBand(scanner);
                    break;
                case 5:
                    cariPlaylist(scanner);
                    break;
                case 6:
                    iya = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

    }

    /*
     * Method Untuk Menu cari Musik
     */

    // cari lagu
    private static void cariLagu(Scanner scanner) {
        System.out.print("Masukkan judul lagu: ");
        String judul = scanner.nextLine();

        Songs lagu = cariLaguDenganJudul(judul);
        if (lagu != null) {
            lagu.displayInfo();
        } else {
            System.out.println("Lagu tidak ditemukan.");
        }
    }

    // cari album
    private static void cariAlbum(Scanner scanner) {
        System.out.print("Masukkan nama album: ");
        String namaAlbum = scanner.nextLine();

        Album album = cariAlbumDenganNama(namaAlbum);
        if (album != null) {
            album.displayInfo();
        } else {
            System.out.println("Album tidak ditemukan.");
        }
    }

    // cari artis
    private static void cariArtis(Scanner scanner) {
        System.out.print("Masukkan nama artis: ");
        String namaArtis = scanner.nextLine();

        Artist artis = cariArtisDenganNama(namaArtis);
        if (artis != null) {
            artis.displayInfo();
        } else {
            System.out.println("Artis tidak ditemukan.");
        }
    }

    // cari band
    private static void cariBand(Scanner scanner) {
        System.out.print("Masukkan nama band: ");
        String namaBand = scanner.nextLine();

        Band band = cariBandDenganNama(namaBand);
        if (band != null) {
            band.displayInfo();
        } else {
            System.out.println("Band tidak ditemukan.");
        }
    }

    // cari playlist
    private static void cariPlaylist(Scanner scanner) {
        System.out.print("Masukkan nama playlist: ");
        String namaPlaylist = scanner.nextLine();

        Playlist playlist = cariPlaylistDenganNama(namaPlaylist);
        if (playlist != null) {
            playlist.displayInfo();
        } else {
            System.out.println("Playlist tidak ditemukan.");
        }
    }

    // method untuk menu Antrean Musik menggunakan Queue
    private static void menuAntreanMusik(Scanner scanner) {
        boolean mari = true;
        while (mari) {
            System.out.println("\n--- Antrean Musik ---");
            System.out.println("1. Tambah ke Antrean");
            System.out.println("2. Putar Antrean");
            System.out.println("3. Tampilkan Antrean");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengkonsumsi baris baru

            switch (pilihan) {
                case 1:
                    tambahKeAntrean(scanner);
                    break;
                case 2:
                    putarAntrean();
                    break;
                case 3:
                    tampilkanAntrean();
                    break;
                case 4:
                    mari = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    /*
     * Method untuk Antrean
     */

    // membuat method untuk menambahkan lagu ke antrean
    private static void tambahKeAntrean(Scanner scanner) {
        System.out.print("Masukkan judul lagu untuk ditambahkan ke antrean: ");
        String judul = scanner.nextLine();

        Songs lagu = cariLaguDenganJudul(judul);
        if (lagu != null) {
            antrean.tambahAntrean(lagu);
            riwayat.push(lagu);
            System.out.println("Lagu ditambahkan ke antrean.");
        } else {
            System.out.println("Lagu tidak ditemukan di perpustakaan.");
        }
    }

    // method untuk memutar antrean
    private static void putarAntrean() {
        Songs lagu = antrean.putarAntrean();
        if (lagu != null) {
            System.out.println("Sedang memutar: \n- " + lagu.getJudul() + " oleh " + lagu.getArtis());
        }
    }

    // method untuk menampilkan semua lagu dalam antrean
    private static void tampilkanAntrean() {
        System.out.println("\n---------------");
        System.out.println("--- Antrean ---");
        antrean.displayInfo();
    }

    /*
     * Method Untuk Menampilkan Riwayat Musik
     */

    // menampilkan history lagu
    private static void tampilkanRiwayatMusik(Scanner scanner) {
        System.out.println("\n--- Riwayat ---");
        riwayat.displayInfo();

        System.out.println("\n1. Hapus Riwayat");
        System.out.println("2. Keluar");
        System.out.print("Pilih opsi: ");

        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Mengkonsumsi baris baru

        switch (pilihan) {
            case 1:
                hapusRiwayat();
                break;
            case 2:
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    // method untuk hapus history
    private static void hapusRiwayat() {
        while (!riwayat.isEmpty()) {
            riwayat.pop();
        }
        System.out.println("Riwayat dihapus.");
    }

    // Method untuk menu perpustakaan lagu / songLibrary
    private static void menuPerpustakaanLagu(Scanner scanner) {
        System.out.println("\n--- Perpustakaan Lagu ---");
        System.out.println("1. Tambah Lagu");
        System.out.println("2. Hapus Lagu");
        System.out.println("3. Tampilkan");
        System.out.print("Pilih opsi: ");

        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Mengkonsumsi baris baru

        switch (pilihan) {
            case 1:
                tambahLagu(scanner);
                break;
            case 2:
                hapusLagu(scanner);
                break;
            case 3:
                tampilkanPerpustakaanLagu();
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    // method untuk hapus lagu
    private static void hapusLagu(Scanner scanner) {
        System.out.print("Masukkan judul lagu untuk dihapus: ");
        String judul = scanner.nextLine();

        Songs lagu = cariLaguDenganJudul(judul);
        if (lagu != null) {
            perpustakaanLagu.remove(lagu);
            System.out.println("Lagu dihapus dari perpustakaan.");
        } else {
            System.out.println("Lagu tidak ditemukan.");
        }
    }

    // method untuk menampilkan songLibrary
    private static void tampilkanPerpustakaanLagu() {
        System.out.println("--- Perpustakaan Lagu ---");
        int i = 1;
        for (Songs lagu : perpustakaanLagu) {
            System.out.println("");
            System.out.print(i + ". ");
            lagu.displayInfo();
            i++;
        }
    }
}
