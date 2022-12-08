package com.example.fullstackapp.domain;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

@Service
public class TimeService {
    public ZonedDateTime getZonedDateTime() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }
}
