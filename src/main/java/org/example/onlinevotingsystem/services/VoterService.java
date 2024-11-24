package org.example.onlinevotingsystem.services;

import org.example.onlinevotingsystem.models.Voter;
import org.example.onlinevotingsystem.repositories.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VoterService {

    @Autowired
    private VoterRepository voterRepository;

    // Get Voter by NID
    public Optional<Voter> getVoterByNid(int nid) {
        return voterRepository.findById(nid);
    }

    // Get Voter by Username
    public Optional<Voter> getVoterByUsername(String username) {
        return voterRepository.findByUsername(username);
    }

    // Get Voter by Email
    public Optional<Voter> findByEmail(String email) {
        return voterRepository.findByEmail(email);
    }

    // Create or Update Voter
    public Voter saveVoter(Voter voter) {
        if (voterRepository.findByUsername(voter.getUsername()).isPresent()) {
            throw new UsernameNotFoundException("Username already exists");
        }
        return voterRepository.save(voter);
    }

    public void enableVoter(int nid) {
        Voter voter = voterRepository.findById(nid).orElseThrow();
        voter.setEnabled(true);
        voterRepository.save(voter);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Voter voter = voterRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_USER")
        );

        return new org.springframework.security.core.userdetails.User(
                voter.getUsername(),
                voter.getPassword(),
                voter.isEnabled(),
                true,
                true,
                true,
                authorities
        );
    }

}
