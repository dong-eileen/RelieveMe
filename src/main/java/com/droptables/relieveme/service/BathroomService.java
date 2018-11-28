package com.droptables.relieveme.service;

import com.droptables.relieveme.repository.BathroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BathroomService {

    private BathroomRepository bathroomRepository;

    /**
     * The Service layer for the bathroom table.
     *
     * @param bathroomRepository - automatically injected by the Spring framework
     */
    @Autowired
    public BathroomService(BathroomRepository bathroomRepository) {
        this.bathroomRepository = bathroomRepository;
    }

    /**
     * Increments the positive rating of the bathroom in the database with given id.
     * @param bathroomId non-null bathroom identifier
     */
    public void incrementNumPositiveRating(Integer bathroomId) {
        bathroomRepository.incrementNumPositiveRating(bathroomId);
    }

    /**
     * Increments the negative rating of the bathroom in the database with given id.
     * @param bathroomId non-null bathroom identifier
     */
    public void incrementNumNegativeRating(Integer bathroomId) {
        bathroomRepository.incrementNumNegativeRating(bathroomId);
    }

    /**
     * Sets the maintenance issue flag of the bathroom in the database with given id to true.
     * @param bathroomId non-null bathroom identifier
     */
    public void setOngoingBathroomIssueToTrue(Integer bathroomId) {
        bathroomRepository.setOngoingBathroomIssueToTrue(bathroomId);
    }
}
