package com.example.BasicToAdvance.Jarnal.Repository;

import com.example.BasicToAdvance.Jarnal.model.JarnalSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JarnalRepository extends JpaRepository<JarnalSchema, UUID> {
     JarnalSchema findByTitle(String title);
     List<JarnalSchema> findByEmail(String email);
}
