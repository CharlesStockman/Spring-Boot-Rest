package chuck.springframework.lab1.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import chuck.springframework.lab1.domain.Team;

/**
 * Spring Data Rest produces hypermedia driven Rest web services
 * on top of Spring Data Repositories
 * 
 * Builds on top of Spring Data Repositories, analyzes  your 
 * application's domain model and exposes hypermeidia driven
 * http resources and aggregates contianed in the model.
 */
@Profile("controller")
public interface DatabaseTeamRepository extends CrudRepository<Team, Long> {}; 