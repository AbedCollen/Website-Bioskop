package com.fti.pl.PLSpringBootHibernate.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_jadwalfilm")
public class JadwalFilm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "film")
    private String film;

    @Column(name = "hari")
    private String hari;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "studio")
    private int studio;

    @Column(name = "harga")
    private int harga;

    @Column(name = "status")
    private String status;
    public JadwalFilm(){}

    public JadwalFilm(int id, String film,String hari, String date, String time, int studio, int harga,  String status) {
        this.id = id;
        this.film = film;
        this.hari = hari;
        this.date = date;
        this.time = time;
        this.studio = studio;
        this.harga = harga;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStudio() {
        return studio;
    }

    public void setStudio(int studio) {
        this.studio = studio;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
