package com.app.demo.data.repo;

import com.app.demo.data.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonDAO extends JpaRepository<PersonModel, UUID> {
}
