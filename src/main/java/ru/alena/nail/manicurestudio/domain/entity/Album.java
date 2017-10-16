package ru.alena.nail.manicurestudio.domain.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Альбом для фотографий, отображаемый на сайте маникюрной студии
 *
 * @author Gubanov Artyom.
 */
@Entity
@Table(name = "album")
public class Album extends DBObject {

    /**
     * Уникальный идентификатор альбома
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_seq'")
    @SequenceGenerator(name = "album_id_seq'", sequenceName = "album_id_seq'", allocationSize = 1)
    private Long id;

    /**
     * Наименование альбома
     */
    @Column(name = "name")
    private String name;

    /**
     * Список фотографий, относящихся к данному альбому
     */
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "album")
    private List<Photo> photos;

    @Override
    public Long getId() {
        return null;
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

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

}
