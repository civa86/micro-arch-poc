package info.civa86.photoservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info.civa86.photoservice.exceptions.ItemForbiddenException;
import info.civa86.photoservice.exceptions.ItemNotFoundException;
import info.civa86.photoservice.model.Album;
import info.civa86.photoservice.model.Picture;
import info.civa86.photoservice.service.AlbumService;
import info.civa86.photoservice.service.PictureService;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private PictureService pictureService;

    @GetMapping(value = "/albums")
    public List<Album> getAlbumList(
            @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId) {
        return albumService.findAll(userId);
    }

    private Album findAlbumById(int id, int userId) throws ItemNotFoundException, ItemForbiddenException {
        return this.albumService.getAlbumByIdAndCheckUser(id, userId);
    }

    @GetMapping(value = "/album/{id}")
    public Album getAlbum(@PathVariable(value = "id") Integer id,
    @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId)
            throws ItemNotFoundException, ItemForbiddenException {
        return findAlbumById(id, userId);
    }

    @GetMapping(value = "/album/{id}/pictures")
    public List<Picture> getAlbumPictures(@PathVariable(value = "id") Integer id, @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId)
            throws ItemNotFoundException, ItemForbiddenException {
        Album album = this.getAlbum(id, userId);
        return pictureService.findPicturesByAlbumId(album.getId(), userId);
    }

    @PostMapping(value = "/album")
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAlbum(@RequestBody @Valid Album album,
    @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId) {
        Album newAlbum = new Album(album);

        newAlbum.setUserId(userId);

        this.albumService.saveAlbum(newAlbum);

        return newAlbum;

    }

    @PutMapping(value = "/album/{id}")
    public Album updateAlbum(@PathVariable(value = "id") Integer id, @RequestBody @Valid Album album,
    @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId)
            throws ItemNotFoundException, ItemForbiddenException {
        Album editAlbum = findAlbumById(id, userId);

        editAlbum.setName(album.getName());

        this.albumService.saveAlbum(editAlbum);

        return editAlbum;
    }

    @DeleteMapping(value = "/album/{id}")
    public Album deleteAlbum(@PathVariable(value = "id") Integer id,
    @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId)
            throws ItemNotFoundException, ItemForbiddenException {
        Album deleteAlbum = findAlbumById(id, userId);

        this.albumService.deleteAlbum(id);

        return deleteAlbum;
    }
}