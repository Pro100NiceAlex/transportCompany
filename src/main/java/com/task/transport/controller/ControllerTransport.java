package com.task.transport.controller;

import com.task.transport.model.Transport;
import com.task.transport.service.TransportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class ControllerTransport {
    private final TransportService transportService;
    public ControllerTransport(TransportService transportService) {
        this.transportService = transportService;
    }
    @GetMapping
    public String mainPage(Map<String, Object> model) {
        Iterable<Transport> transport = transportService.findByAll();
        model.put("transport", transport);
        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam (required = false) String filterStateNumber,
                         @RequestParam (required = false) String filterBrand,
                         @RequestParam (required = false) String filterModel,
                         @RequestParam (required = false) String filterCategory,
                         @RequestParam (required = false) String filterYearRelease,
                         Map<String, Object> model) {
        Iterable<Transport> transport;
        transport = transportService.findByFilter(filterStateNumber, filterBrand, filterModel, filterCategory, filterYearRelease);
        model.put("transport", transport);
        return "main";
    }
}
