package com.voting.votingApp.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Embeddable
public class OptionVote {

    private String voteOption;
    private Long voteCount = 0L;

    public String getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(String voteOption) {
        this.voteOption = voteOption;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }


}
