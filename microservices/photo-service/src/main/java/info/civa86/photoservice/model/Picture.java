package info.civa86.photoservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "picture")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    @NotNull
    @NotBlank
    private String title;

    @Column(name = "mime_type")
    @NotNull
    @NotBlank
    private String mimeType;

    @Lob
    @Column(name = "image")
    @NotNull
    @NotEmpty
    @JsonIgnore
    private byte[] image;

    @Column(name = "album_id")
    @NotNull
    private int albumId;

    @Column(name = "user_id")
    @JsonIgnore
    private int userId;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    public Picture() {
    }

    public Picture(Picture pic) {
        this.id = pic.id;
        this.title = pic.title;
        this.mimeType = pic.mimeType;
        this.image = pic.image;
        this.albumId = pic.albumId;
        this.userId = pic.userId;
        this.createdAt = pic.createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getUserId() {
        return userId;
    }

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
