package com.omniwyse.tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.tracker.Message;
import com.omniwyse.tracker.service.KafkaService;

@RestController
public class TrackerController {

    @Autowired
    private KafkaService kafka;

    @RequestMapping("/")
    String home() {
        return "Welcome to Tracker application!";
    }

    @RequestMapping(path = "/track", method = RequestMethod.POST, headers = "content-type=application/json")
    String track(@RequestBody Message message) {
        kafka.send(message);
        return "acknowledged";
    }
}