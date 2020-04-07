package chuck.springframework.lab1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import chuck.springframework.lab1.domain.Player;

/**
 * Spring Data JPA used to easily implement JPA based repositories
 */
@RestResource(path="players", rel="player")
public interface PlayerRepository extends CrudRepository<Player, Long>{};