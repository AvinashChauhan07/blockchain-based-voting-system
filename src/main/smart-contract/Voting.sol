// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Voting {
    struct Candidate {
        uint id;
        string name;
        string party;
        uint votes;
    }

    mapping(uint => Candidate) public candidates;
    uint public candidatesCount;

    mapping(address => bool) public hasVoted;

    event CandidateAdded(uint id, string name, string party);
    event Voted(address indexed voter, uint indexed candidateId);

    // add candidate (admin)
    function addCandidate(string memory _name, string memory _party) public {
        candidatesCount++;
        candidates[candidatesCount] = Candidate(candidatesCount, _name, _party, 0);

        emit CandidateAdded(candidatesCount, _name, _party);
    }

    // cast vote
    function castVote(uint _candidateId) public {
        require(!hasVoted[msg.sender], "You have already voted");
        require(_candidateId > 0 && _candidateId <= candidatesCount, "Invalid candidate");

        candidates[_candidateId].votes++;
        hasVoted[msg.sender] = true;

        emit Voted(msg.sender, _candidateId);
    }

    // get vote count
    function getVotes(uint _candidateId) public view returns (uint) {
        return candidates[_candidateId].votes;
    }
}
