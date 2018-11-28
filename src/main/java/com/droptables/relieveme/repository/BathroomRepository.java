package com.droptables.relieveme.repository;

import com.droptables.relieveme.domain.Bathroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.List;

@Repository()
public interface BathroomRepository extends JpaRepository<Bathroom, Long> {

    /**
     * Increments the positive rating of the bathroom in the database with given id.
     * @param bathroomId bathroom identifier
     */
    @Transactional
    @Modifying
    @Query("UPDATE Bathroom SET num_positive_rating = num_positive_rating + 1 WHERE bathroomId = ?1")
    void incrementNumPositiveRating(int bathroomId);

    /**
     * Increments the negative rating of the bathroom in the database with given id.
     * @param bathroomId bathroom identifier
     */
    @Transactional
    @Modifying
    @Query("UPDATE Bathroom SET num_negative_rating = num_negative_rating + 1 WHERE bathroomId = ?1")
    void incrementNumNegativeRating(int bathroomId);

    /**
     * Sets the maintenance issue flag to true of the bathroom in the database with given id.
     * @param bathroomId bathroom identifier
     */
    @Transactional
    @Modifying
    @Query("UPDATE Bathroom SET ongoing_bathroom_issue = true WHERE bathroomId = ?1")
    void setOngoingBathroomIssueToTrue(int bathroomId);
}