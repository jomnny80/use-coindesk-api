package com.coindesk.repositories;

import com.coindesk.models.Coindesk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoindeskRepository extends JpaRepository<Coindesk, Long> {
}
