package com.droptables.relieveme.controller;

import com.droptables.relieveme.service.BathroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${rest-controller-prefix}")
public class RatingController {
    private final BathroomService bathroomService;

    @Autowired
    public RatingController(BathroomService bathroomService) {
        this.bathroomService = bathroomService;
    }

    /**
     * Increases the positive rating for a bathroom.
     *
     * @param bathroomId non-null identifier of a bathroom
     */
    @PostMapping("/bathroom/{bathroomId}/increasePositiveRating")
    public void increaseBathroomPositiveRating(@PathVariable Integer bathroomId) {
        bathroomService.incrementNumPositiveRating(bathroomId);
    }

    /**
     * Increases the negative rating for a bathroom.
     *
     * @param bathroomId non-null identifier of a bathroom
     */
    @PostMapping("/bathroom/{bathroomId}/increaseNegativeRating")
    public void increaseBathroomNegativeRating(@PathVariable Integer bathroomId) {
        bathroomService.incrementNumNegativeRating(bathroomId);
    }
}
