package ru.alena.nail.manicurestudio.domain.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Базовый класс всех доменных объектов, используемых для взаимодействия с БД
 *
 * @author Gubanov Artyom.
 */
@MappedSuperclass
public abstract class DBObject implements Serializable {

    /**
     * Получить уникальный идентификатор доменного объекта
     *
     * @return уникальный идентификатор доменного объекта
     */
    public abstract Long getId();


    /**
     * Проверить является доменный объект новым, не сохраненным в БД
     *
     * @return признак, того, что доменный объект является новым, т.е не сохранен в БД
     */
    public Boolean isNew() {
        return getId() == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DBObject dbObject = (DBObject) o;

        return getId() != null ? getId().equals(dbObject.getId()) : dbObject.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

}


