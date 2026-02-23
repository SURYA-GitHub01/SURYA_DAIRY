package com.example.surya_virtual_diary.repository;

import com.example.surya_virtual_diary.models.PreciousMetalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreciousMetalRepository extends JpaRepository<PreciousMetalEntry, Long> {
    List<PreciousMetalEntry> findByTypeIgnoreCase(String type);
}
