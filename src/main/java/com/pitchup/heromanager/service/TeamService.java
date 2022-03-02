package com.pitchup.heromanager.service;

import com.pitchup.heromanager.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private final TeamRepository TeamRepository;

    @Autowired
    public TeamService(TeamRepository TeamRepository){ this.TeamRepository = TeamRepository; }

    //public Team addTeam(Team team){}
}
