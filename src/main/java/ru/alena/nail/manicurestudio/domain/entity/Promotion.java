package ru.alena.nail.manicurestudio.domain.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Акция (рекламная акция, скидка), проводимая студией маникюра
 *
 * @author Gubanov Artyom.
 */
@Entity
@Table(name = "promotion")
public class Promotion extends DBObject{

    /**
     * Уникальный идентификатор акции
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "promotion_id_seq")
    @SequenceGenerator(name = "promotion_id_seq", sequenceName = "promotion_id_seq", allocationSize = 1)
    private Long id;

    /**
     * Наименование акции
     */
    @Column(name = "name")
    private String name;

    /**
     * Описание акции
     */
    @Column(name = "description")
    private String description;

    /**
     * Даьа старта (начала) акции
     */
    @Column(name = "start_date")
    private Date start_date;

    /**
     * Дата окончания действия ации
     */
    @Column(name = "end_date")
    private Date end_date;


    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

}
