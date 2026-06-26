package com.examly.springapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.ItineraryEvent;
import com.examly.springapp.service.ItineraryService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/itinerary")

public class ItineraryController {
    
    private final ItineraryService service;
    @PostMapping
    public ItineraryEvent addEvent(@RequestBody ItineraryEvent event){
        return service.addTravel(event);
    }
    @GetMapping
    public List<ItineraryEvent>getAllEvents(){
        return service.getTravel();
    }
    @GetMapping("/{tripName}")
    public List<ItineraryEvent> getByName(@PathVariable String tripName){
        return service.getTripByName(tripName);
    }
    

}
