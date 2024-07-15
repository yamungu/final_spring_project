package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.model.Feedback;
import com.entrepreneur.brent_with_sas.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@ComponentScan
@RestController
@RequestMapping("/api/v1/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    @GetMapping
    public List<Feedback> getAll(){
        return feedbackService.getAll();}

    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable Integer id){
        return feedbackService.getFeedbackById(id);
    }

    @PostMapping
    public void create(@RequestBody Feedback feedback){
        feedbackService.create(feedback);
    }

    @PutMapping("/{id}")
    public void updateFeedback(@PathVariable Integer id,@RequestBody Feedback feedback){
        feedbackService.updateFeedback(id,feedback);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){feedbackService.delete(id);}

}
