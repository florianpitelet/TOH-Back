package com.pitchup.heromanager.service;

import com.pitchup.heromanager.Repository.EquipeRepository;
import com.pitchup.heromanager.exception.EquipeNotFoundException;
import com.pitchup.heromanager.model.Hero;
import com.pitchup.heromanager.model.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EquipeService {

    private final EquipeRepository EquipeRepository;
    private final HeroService HeroService;

    @Autowired
    public EquipeService(EquipeRepository EquipeRepository, HeroService HeroService){
        this.EquipeRepository = EquipeRepository;
        this.HeroService = HeroService;
    }

    //ADD TEAM
    public Equipe addTeam(Equipe equipe){

        equipe.setNom(equipe.getNom());
        return EquipeRepository.save(equipe);
    }

    //Get all teams
    public List<Equipe> findAllTeams(){ return EquipeRepository.findAll(); }

    //Get one team
    public Equipe findTeamById(Long id) { return EquipeRepository.findTeamById(id)
            .orElseThrow( () -> new EquipeNotFoundException("Team not found")); }


    //Edit a team
    public Equipe updateTeam(Equipe equipe){ return EquipeRepository.save(equipe); }

    //Delete a team
    public void deleteTeamById(Long id) { EquipeRepository.deleteById(id); }


    public void addHeroToTeam(Long team_id, Long id) {
        // on recuper le heros
        Hero heroToAdd = HeroService.findHeroById(id);
        heroToAdd.setTeamId(team_id);
        HeroService.updateHero(heroToAdd);

    }
}
