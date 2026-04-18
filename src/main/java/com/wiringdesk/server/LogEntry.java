package com.wiringdesk.server;

import jakarta.persistence.*;

@Entity
@Table(name = "logs")
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licenseKey;
    private String hwid;
    private String event;
    private String status;
    private String city;
    private String ipAddress;

    public Long getId() { return id; }

    public String getLicenseKey() { return licenseKey; }
    public void setLicenseKey(String licenseKey) { this.licenseKey = licenseKey; }

    public String getHwid() { return hwid; }
    public void setHwid(String hwid) { this.hwid = hwid; }

    public String getEvent() { return event; }
    public void setEvent(String event) { this.event = event; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
}