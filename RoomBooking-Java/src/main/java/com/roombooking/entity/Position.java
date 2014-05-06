package com.roombooking.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Collection;

import static com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@JsonInclude(Include.NON_NULL)
public class Position {

    private int id;
    private String title;
    private Collection<Right> rights;
    private Collection<User> users;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position that = (Position) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "position")
    public Collection<Right> getRights() {
        return rights;
    }

    public void setRights(Collection<Right> rightsById) {
        this.rights = rightsById;
    }

    @OneToMany(mappedBy = "position")
    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> usersById) {
        this.users = usersById;
    }

}