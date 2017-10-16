package ru.alena.nail.manicurestudio.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Услуга, предоставляемая студией маникюра
 *
 * @author Gubanov Artyom.
 */
@Entity
@Table(name = "service")
public class Service extends DBObject {

    /**
     * Уникальный идентификатор услуги
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_id_seq")
    @SequenceGenerator(name = "service_id_seq", sequenceName = "service_id_seq", allocationSize = 1)
    private Long id;

    /**
     * Наименование услуги
     */
    @Column(name = "name")
    private String name;

    /**
     * Описание услуги
     */
    @Column(name = "description")
    private String description;

    /**
     * Цена на услугу
     */
    @Column(name = "price")
    private BigDecimal price;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
