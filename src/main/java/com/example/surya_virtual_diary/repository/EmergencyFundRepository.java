package com.example.surya_virtual_diary.repository;

import com.example.surya_virtual_diary.models.EmergencyFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyFundRepository extends JpaRepository<EmergencyFund, Long> {
}
