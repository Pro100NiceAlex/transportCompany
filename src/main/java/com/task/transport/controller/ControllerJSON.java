package com.task.transport.controller;

import com.task.transport.model.Transport;
import com.task.transport.service.TransportService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerJSON {
    private final TransportService transportService;
    public ControllerJSON(TransportService transportService) {
        this.transportService = transportService;
    }
    @PostMapping("insert")
    public Boolean insert(@RequestBody Transport transport) {
        transportService.insertNewTransport(transport);
        return true;
    }
    @PostMapping("delete")
    public Boolean delete(@RequestBody Transport transport) {
        transportService.deleteTransport(transport);
        return true;
    }
    @PostMapping("inf")
    public Transport inf(@RequestBody Transport transport) {
        transport = transportService.informTransport(transport);
        return transport;
    }
    @PostMapping("edit")
    public Boolean edit(@RequestBody Transport transport) {
        if(transport.getBrand() == null) return true;
        transportService.editingTransport(transport);
        return true;
    }
}

