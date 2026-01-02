
package com.dvs.project.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.dvs.project.repository.VoterRepository;
import com.dvs.project.entity.Voter;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoterService {
    private final VoterRepository voterRepository;

    public Optional<Voter> find(String id){ return voterRepository.findById(id); }
    public Voter add(Voter v){ return voterRepository.save(v); }
    public void markVoted(String id){ voterRepository.findById(id).ifPresent(v->{ v.setVoted(true); voterRepository.save(v); }); }
}
