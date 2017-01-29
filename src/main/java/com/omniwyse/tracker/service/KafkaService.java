package com.omniwyse.tracker.service;

import org.springframework.stereotype.Service;

import com.omniwyse.tracker.Message;

@Service
public class KafkaService {
    public void send(Message message) {
        System.out.println(message.getData());
    }
}
