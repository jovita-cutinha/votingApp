package com.voting.votingApp.repository;

import com.voting.votingApp.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PollRepository extends JpaRepository<Poll, Long> {

}
