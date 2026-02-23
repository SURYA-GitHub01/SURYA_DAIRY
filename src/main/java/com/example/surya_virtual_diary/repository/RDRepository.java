package com.example.surya_virtual_diary.repository;

import com.example.surya_virtual_diary.models.RecurringDepositEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RDRepository extends JpaRepository<RecurringDepositEntry, Long> {
}
