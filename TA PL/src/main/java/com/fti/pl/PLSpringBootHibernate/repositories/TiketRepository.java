package com.fti.pl.PLSpringBootHibernate.repositories;


import com.fti.pl.PLSpringBootHibernate.models.Tiket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiketRepository extends JpaRepository<Tiket, Integer> {
}
