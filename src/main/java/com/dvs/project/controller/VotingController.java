
package com.dvs.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.dvs.project.service.CandidateService;
import com.dvs.project.service.VoterService;
import com.dvs.project.service.VotingService;
import com.dvs.project.entity.Voter;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class VotingController {
    private final CandidateService candidateService;
    private final VoterService voterService;
    private final VotingService votingService;

    @GetMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("candidates", candidateService.listAll());
        return "index";
    }

    @PostMapping("/vote")
    public String vote(@RequestParam String voterId, @RequestParam Long candidateId, Model model){
        // simple check
        Voter v = voterService.find(voterId).orElse(null);
        if(v==null){ model.addAttribute("error", "Voter not found"); return "index"; }
        if(v.isVoted()){ model.addAttribute("error", "Already voted"); return "index"; }

        // record locally (and potentially send to blockchain via Web3j)
        votingService.recordVote(voterId, candidateId);
        voterService.markVoted(voterId);
        model.addAttribute("success", "Vote recorded (server-side).");
        model.addAttribute("candidates", candidateService.listAll());
        return "index";
    }
}
