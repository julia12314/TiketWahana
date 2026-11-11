/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiketwahana;
import java.io.Serializable;


/**
 *
 * @author USER
 */
public class ZonaWahana implements Serializable {
    private static final long serialVersionUID = 1L;
    private String namaZona;
    private int kapasitasPengunjung;

    public ZonaWahana(String namaZona, int kapasitasPengunjung) {
        this.namaZona = namaZona;
        this.kapasitasPengunjung = kapasitasPengunjung;
    }

    public void bukaZona() {
        System.out.println("- Zona \"" + namaZona + "\" dibuka. Kapasitas: " + kapasitasPengunjung + " orang.");
    }
}
