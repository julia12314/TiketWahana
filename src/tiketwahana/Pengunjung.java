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
public class Pengunjung implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idPengunjung;
    private String nama;

    public Pengunjung(String idPengunjung, String nama) {
        this.idPengunjung = idPengunjung;
        this.nama = nama;
    }

    public String getIdPengunjung() { return idPengunjung; }
    public String getNama() { return nama; }
}
