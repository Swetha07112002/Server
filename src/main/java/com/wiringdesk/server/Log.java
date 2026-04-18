package com.wiringdesk.server;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String hwid;
    private String event;

    private LocalDateTime time = LocalDateTime.now();

    public int getId() { return id; }

    public String getHwid() { return hwid; }
    public void setHwid(String hwid) { this.hwid = hwid; }

    public String getEvent() { return event; }
    public void setEvent(String event) { this.event = event; }

    public LocalDateTime getTime() { return time; }
}