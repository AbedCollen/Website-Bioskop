package com.fti.pl.PLSpringBootHibernate.repositories;

import com.fti.pl.PLSpringBootHibernate.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    List<Film> findByStatus (String status);
}
