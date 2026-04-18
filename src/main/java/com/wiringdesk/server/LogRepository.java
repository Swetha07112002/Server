package com.wiringdesk.server;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LogRepository extends JpaRepository<LogEntry, Long> {

    Optional<LogEntry> findTopByLicenseKeyOrderByIdDesc(String licenseKey);
}