package com.fti.pl.PLSpringBootHibernate.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "judul")
    private String judul;

    @Column(name = "durasi_film")
    private String durasi_film;

    @Column(name = "start_date")
    private String start_date;

    @Column(name = "end_date")
    private String end_date;

    @Column(name = "status")
    private String status;

    public Film(){}

    public Film(int id, String judul, String durasi_film, String start_date, String end_date,String status) {
        this.id = id;
        this.judul = judul;
        this.durasi_film = durasi_film;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDurasi_film() {
        return durasi_film;
    }

    public void setDurasi_film(String durasi_film) {
        this.durasi_film = durasi_film;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
