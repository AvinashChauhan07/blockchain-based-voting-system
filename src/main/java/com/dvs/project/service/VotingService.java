
package com.dvs.project.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dvs.project.entity.VoteRecord;
import com.dvs.project.repository.VoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VotingService {
    private final VoteRepository voteRepository;

    public VoteRecord recordVote(String voterId, Long candidateId){
        VoteRecord vr = new VoteRecord();
        vr.setId(voterId + "::" + Instant.now().toEpochMilli());
        vr.setVoterId(voterId);
        vr.setCandidateId(candidateId);
        vr.setTimestamp(Instant.now().toString());
        voteRepository.save(vr);
        return vr;
    }
}
