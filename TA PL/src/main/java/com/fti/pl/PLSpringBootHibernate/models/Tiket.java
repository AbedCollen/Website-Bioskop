package com.fti.pl.PLSpringBootHibernate.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tiket")
public class Tiket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "jadwal")
    private int jadwal;

    @Column(name = "jumlah_tiket")
    private int jumlah_tiket;

    @Column(name = "total")
    private int total;

    public Tiket (){}

    public Tiket(int id, int jadwal, int jumlah_tiket, int total) {
        this.id = id;
        this.jadwal = jadwal;
        this.jumlah_tiket = jumlah_tiket;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJadwal() {
        return jadwal;
    }

    public void setJadwal(int jadwal) {
        this.jadwal = jadwal;
    }

    public int getJumlah_tiket() {
        return jumlah_tiket;
    }

    public void setJumlah_tiket(int jumlah_tiket) {
        this.jumlah_tiket = jumlah_tiket;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
