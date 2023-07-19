package com.fti.pl.PLSpringBootHibernate.repositories;


import com.fti.pl.PLSpringBootHibernate.models.Studio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<Studio, Integer> {
}
