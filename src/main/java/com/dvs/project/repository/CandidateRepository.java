
package com.dvs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dvs.project.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long> { }
