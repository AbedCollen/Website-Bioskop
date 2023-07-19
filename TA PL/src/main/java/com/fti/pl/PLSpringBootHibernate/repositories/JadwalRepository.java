package com.fti.pl.PLSpringBootHibernate.repositories;


import com.fti.pl.PLSpringBootHibernate.models.Film;
import com.fti.pl.PLSpringBootHibernate.models.JadwalFilm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.List;

public interface JadwalRepository extends JpaRepository<JadwalFilm, Integer> {

    List<JadwalFilm> findByTimeAndDate (String time, String date);

    List<JadwalFilm> findByStatus (String status);
}
