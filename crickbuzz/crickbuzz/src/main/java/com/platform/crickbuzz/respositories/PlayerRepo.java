package com.platform.crickbuzz.respositories;

import com.platform.crickbuzz.entities.Matches;
import com.platform.crickbuzz.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepo  extends JpaRepository<Player,Integer> {

    List<Optional<Player>> findByCountry(String country);

    Optional<Player> findByName(String name);

}