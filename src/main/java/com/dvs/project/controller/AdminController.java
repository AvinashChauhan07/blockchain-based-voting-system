
package com.dvs.project.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.dvs.project.entity.Candidate;
import com.dvs.project.entity.Voter;
import com.dvs.project.service.CandidateService;
import com.dvs.project.service.VoterService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final CandidateService candidateService;
    private final VoterService voterService;

    @GetMapping("/panel")
    public String panel(Model model){
        List<Candidate> candidates = candidateService.listAll();
        model.addAttribute("candidates", candidates);
        return "admin";
    }

    @PostMapping("/candidate")
    public String addCandidate(@ModelAttribute Candidate candidate){
        candidateService.add(candidate);
        return "redirect:/admin/panel";
    }

    @PostMapping("/voter")
    public String addVoter(@ModelAttribute Voter voter){
        voterService.add(voter);
        return "redirect:/admin/panel";
    }
}
