package jorn.hiel.urentracker.business.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;


/**
 * @author Hiel Jorn
 * @version 1.0
 * <p>
 *     pojo to hold a day to-work hours
 * </p>
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "configdays")
@ToString

public class ConfigDay  {
    @Id
    @Column(name = "dag")
    private String dag;
    @Column(name = "uren")
    private LocalTime hours;

}
