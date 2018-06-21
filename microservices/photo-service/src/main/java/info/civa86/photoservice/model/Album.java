package info.civa86.photoservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "user_id")
    @JsonIgnore
    private int userId;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    public Album() {
    }

    public Album(Album album) {
        this.id = album.id;
        this.name = album.name;
        this.userId = album.userId;
        this.createdAt = album.createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public int getUserId() {
        return userId;
    }

    @JsonIgnore
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCeatedAt() {
        return createdAt;
    }

    public void setCeatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
