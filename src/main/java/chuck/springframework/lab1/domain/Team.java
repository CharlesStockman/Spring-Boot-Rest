package chuck.springframework.lab1.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
/**
 * A group of people achieving a similar goa
 */
public class Team {

    /**
     * The primary key for the relational database
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * The name of the player 
     */
    String name;

    /**
     * The place where the team has the home court advantage
     */
    String location;

    /*
     * The person or animal adopted by the Team as symbolic figure. 
     */
    String mascot;

    @OneToMany( cascade=CascadeType.ALL)
    @JoinColumn(name="teamId")
    Set<Player> players;

} 