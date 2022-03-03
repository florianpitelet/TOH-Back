package com.pitchup.heromanager.Controller;

import com.pitchup.heromanager.model.Hero;
import com.pitchup.heromanager.model.Team;
import com.pitchup.heromanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService){ this.teamService = teamService; }

    @GetMapping("/all")
    public ResponseEntity<List<Team>> getAllTeams(){
        List<Team> teamsList = teamService.findAllTeams();
        return new ResponseEntity<>(teamsList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Team> getHeroById(@PathVariable("id") Long id){
        Team team = teamService.findTeamById(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Team> addHero(@RequestBody Team team){
        Team newTeam = teamService.addTeam(team);
        return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team){
        Team updatedTeam = teamService.updateTeam(team);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Team> deleteTeam(@PathVariable("id") Long id){
        teamService.deleteTeamById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add/hero/{team_id}/{id}")
    public ResponseEntity<Team> addHerotoTeam(@PathVariable("team_id") Long team_id, @PathVariable("id") Long id, @RequestBody Team team ) {
        Team updatedTeam = teamService.addHeroToTeam(team_id, id);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }





}
