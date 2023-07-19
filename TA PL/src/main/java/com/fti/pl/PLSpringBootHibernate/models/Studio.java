package com.fti.pl.PLSpringBootHibernate.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_studio")
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "kapasitas")
    private int kapasitas;

    public Studio(){}

    public Studio(int id, int kapasitas) {
        this.id = id;
        this.kapasitas = kapasitas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }
}
