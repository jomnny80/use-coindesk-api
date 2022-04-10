package com.coindesk.repositories;

import com.coindesk.models.BPI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BPIRepository extends JpaRepository<BPI, Long> {
}
