package com.platform.crickbuzz.respositories;

import com.platform.crickbuzz.entities.Matches;
import com.platform.crickbuzz.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchesRespository  extends JpaRepository<Matches,Integer> {

}
