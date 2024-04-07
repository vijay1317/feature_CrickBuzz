package com.platform.crickbuzz.respositories;

import com.platform.crickbuzz.entities.Player;
import com.platform.crickbuzz.entities.Squad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadRepo  extends JpaRepository<Squad,Integer> {
}
