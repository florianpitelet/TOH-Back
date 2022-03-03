package com.pitchup.heromanager.service;

import com.pitchup.heromanager.Repository.HeroRepository;
import com.pitchup.heromanager.Repository.TeamRepository;
import com.pitchup.heromanager.exception.TeamNotFoundException;
import com.pitchup.heromanager.model.Hero;
import com.pitchup.heromanager.model.Team;
import com.pitchup.heromanager.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository TeamRepository;
    private final HeroService HeroService;

    @Autowired
    public TeamService(TeamRepository TeamRepository, HeroService HeroService){
        this.TeamRepository = TeamRepository;
        this.HeroService = HeroService;
    }

    //ADD TEAM
    public Team addTeam(Team team){

        team.setNom(team.getNom());
        return TeamRepository.save(team);
    }

    //Get all teams
    public List<Team> findAllTeams(){ return TeamRepository.findAll(); }

    //Get one team
    public Team findTeamById(Long id) { return TeamRepository.findTeamById(id)
            .orElseThrow( () -> new TeamNotFoundException("Team not found")); }


    //Edit a team
    public Team updateTeam(Team team){ return TeamRepository.save(team); }

    //Delete a team
    public void deleteTeamById(Long id) { TeamRepository.deleteById(id); }


    public Team addHeroToTeam(Long team_id, Long id) {
        // on recuper le heros
        Hero heroToAdd = HeroService.findHeroById(id);
        //on recupere la team
        Team teamToUpdate = TeamRepository.findTeamById(team_id)
                .orElseThrow( () -> new TeamNotFoundException("Team not found"));
        teamToUpdate.setTabTeam(heroToAdd);

        //on update la team
        Team updatedTeam = TeamRepository.save(teamToUpdate);
        return updatedTeam;
    }
}
