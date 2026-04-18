package com.wiringdesk.server;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/")
public class TestController {

    private final LicenseRepository repo;
    private final LogRepository logRepository;

    public TestController(LicenseRepository repo, LogRepository logRepository) {
        this.repo = repo;
        this.logRepository = logRepository;
    }

    @PostMapping("/verify")
    public Map<String, Boolean> verify(@RequestBody License lic) {

        System.out.println("========== VERIFY API ==========");
        System.out.println("RECEIVED KEY: " + lic.getLicenseKey());
        System.out.println("RECEIVED HWID: " + lic.getHwid());

        var existing = repo.findByLicenseKey(lic.getLicenseKey());

        // ❌ License not found
        if (existing.isEmpty()) {
            System.out.println("LICENSE NOT FOUND ❌");
            return Map.of("valid", false);
        }

        License dbLic = existing.get();

        System.out.println("DB HWID: " + dbLic.getHwid());

        // ❌ HWID mismatch
        if (!dbLic.getHwid().equals(lic.getHwid())) {
            System.out.println("HWID MISMATCH ❌");
            return Map.of("valid", false);
        }

        System.out.println("LICENSE VALID ✅");

        // ✅ success
        return Map.of("valid", true);
    }
    @PostMapping("/log")
    public String saveLog(@RequestBody LogEntry log) {
        logRepository.save(log);
        System.out.println("LOG SAVED: " + log.getLicenseKey() + " - " + log.getStatus());
        return "OK";
    }

    @GetMapping("/status/{key}")
    public String getStatus(@PathVariable String key) {

        return logRepository
                .findTopByLicenseKeyOrderByIdDesc(key)
                .map(LogEntry::getStatus)
                .orElse("NOT FOUND");
    }
}