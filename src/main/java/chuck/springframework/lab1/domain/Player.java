package chuck.springframework.lab1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A player on a Team
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Player {

    /**
     * The primary key for the relational database
     */
    @Id
    @GeneratedValue
    Long id;

    /**
     * The name of the Player
     */
    private String name;

    /**
     * The position of the Player
     */
    private String position;

}