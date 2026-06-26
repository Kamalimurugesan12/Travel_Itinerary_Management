package com.examly.springapp.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.examly.springapp.model.ItineraryEvent;
import com.examly.springapp.repository.ItineraryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItineraryService {
   // @Autowired
    private final ItineraryRepository repo;

    public ItineraryEvent addTravel(ItineraryEvent event){
        return repo.save(event);
    }
    public List<ItineraryEvent>getTravel(){
        return repo.findAll();
    }
    public List<ItineraryEvent>getTripByName(String tripName){
        return repo.findByTripName(tripName);
    }
    public ItineraryEvent updateItinerary(long id,ItineraryEvent itinerary){
        return repo.findById(id).map(i->{
            i.setTripName(itinerary.getTripName());
            i.setEventDate(itinerary.getEventDate());
            i.setEventLocation(itinerary.getEventLocation());
            i.setEventTime(itinerary.getEventTime());
            i.setEventTitle(itinerary.getEventTitle());
            i.setNotes(itinerary.getNotes());
            return repo.save(i);
        }).orElse(null);
        
    }
    public boolean deleteItinerary(long id){
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }


}
