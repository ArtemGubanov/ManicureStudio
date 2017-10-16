package ru.alena.nail.manicurestudio.domain;

import javax.persistence.*;

/**
 * Фотография (ссылка на фотографию в файловой системе) для альбома, размещенного на сайте минюкюрной студии.
 *
 * @author Gubanov Artyom.
 */
public class Photo extends DBObject {

    /**
     * Уникальный идентификатор фотографии
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "photo_id_seq")
    @SequenceGenerator(name = "photo_id_seq", sequenceName = "photo_id_seq", allocationSize = 1)
    private Long id;

    /**
     * Наименование фотографии, отображающееся на сайте
     */
    @Column(name = "name")
    private String name;

    /**
     * Комментарий к фотографии
     */
    @Column(name = "comment")
    private String comment;

    /**
     * Ссылка на фотографию в файловой системе
     */
    @Column(name = "photo_link")
    private String photoLink;

    /**
     * Ссылка на альбом, к котором распологается фотография на сайте
     */
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn (name = "album_id")
    private Album album;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
