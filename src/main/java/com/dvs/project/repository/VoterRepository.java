
package com.dvs.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dvs.project.entity.Voter;

public interface VoterRepository extends JpaRepository<Voter, String> { }
