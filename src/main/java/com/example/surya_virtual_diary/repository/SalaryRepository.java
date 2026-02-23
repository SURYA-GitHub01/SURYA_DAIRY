package com.example.surya_virtual_diary.repository;

import com.example.surya_virtual_diary.models.SalaryEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<SalaryEntry, Long> {
}
