package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.ItineraryEvent;
@Repository
public interface ItineraryRepository extends JpaRepository<ItineraryEvent,Long> {
    List<ItineraryEvent>findByTripName(String tripName);
}
