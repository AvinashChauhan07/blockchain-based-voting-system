
package com.dvs.project.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.dvs.project.repository.CandidateRepository;
import com.dvs.project.entity.Candidate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public List<Candidate> listAll(){ return candidateRepository.findAll(); }
    public Candidate add(Candidate c){ return candidateRepository.save(c); }
    public void remove(Long id){ candidateRepository.deleteById(id); }
}
