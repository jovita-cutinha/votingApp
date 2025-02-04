package com.voting.votingApp.service;

import com.voting.votingApp.model.OptionVote;
import com.voting.votingApp.model.Poll;
import com.voting.votingApp.repository.PollRepository;
import com.voting.votingApp.request.Vote;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }


    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);

    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        //get the poll from the db
    Poll poll =
        pollRepository.findById(pollId).orElseThrow(() -> new RuntimeException("Invalid poll id"));
        //get the set of options from the poll
        List<OptionVote> voteOptions = poll.getOptions();
        //if index is not valid, throw error
        if(optionIndex<0 || optionIndex>=voteOptions.size()){
            throw new IllegalArgumentException("Invalid option index");
        }
        //get selected option
        OptionVote selectedOption = voteOptions.get(optionIndex);
        // increment the selected option
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);
        //save the incremented option to db
        pollRepository.save(poll);
    }
}
