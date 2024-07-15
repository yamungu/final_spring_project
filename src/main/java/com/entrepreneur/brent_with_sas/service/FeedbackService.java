package com.entrepreneur.brent_with_sas.service;

import com.entrepreneur.brent_with_sas.model.Feedback;
import com.entrepreneur.brent_with_sas.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepo feedbackRepo;

    public List<Feedback> getAll() {return feedbackRepo.findAll();}

    public Feedback getFeedbackById(int id){return feedbackRepo.findById(id).orElse(null);}

    public void create(Feedback feedback){ feedbackRepo.save(feedback); }

    public void updateFeedback(Integer id, Feedback feedback){
        Feedback existingFeedback = feedbackRepo.findById(id).orElse(null);

        if (existingFeedback !=null){
            existingFeedback.setMessage(feedback.getMessage());
            existingFeedback.setDate(feedback.getDate());
            feedbackRepo.save(existingFeedback);
        }
    }
    public void delete(Integer id){feedbackRepo.deleteById(id);}

}
