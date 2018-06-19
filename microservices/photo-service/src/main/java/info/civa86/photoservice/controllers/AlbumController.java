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
import info.civa86.photoservice.service.AlbumService;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping(value = "/albums")
    public List<Album> getAlbumList(
            @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser") String user) {
        return albumService.findAll(user);
    }

    private Album findAlbumById(Integer id, String user) throws ItemNotFoundException, ItemForbiddenException {
        Album album = this.albumService.getAlbumById(id);

        if (album == null) {
            throw new ItemNotFoundException();
        }
        if (!album.getUser().equals(user)) {
            throw new ItemForbiddenException();
        }

        return album;
    }

    @GetMapping(value = "/album/{id}")
    public Album getAlbum(@PathVariable(value = "id") Integer id,
            @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser") String user)
            throws ItemNotFoundException, ItemForbiddenException {
        return findAlbumById(id, user);
    }

    @PostMapping(value = "/album")
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAlbum(@RequestBody @Valid Album album,
            @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser") String user) {
        Album newAlbum = new Album();

        newAlbum.setName(album.getName());
        newAlbum.setUser(user);

        this.albumService.saveAlbum(newAlbum);

        return newAlbum;

    }

    @PutMapping(value = "/album/{id}")
    public Album updateAlbum(@PathVariable(value = "id") Integer id, @RequestBody @Valid Album album,
            @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser") String user)
            throws ItemNotFoundException, ItemForbiddenException {
        Album editAlbum = findAlbumById(id, user);

        editAlbum.setName(album.getName());

        this.albumService.saveAlbum(editAlbum);

        return editAlbum;
    }

    @DeleteMapping(value = "/album/{id}")
    public Album deleteAlbum(@PathVariable(value = "id") Integer id,
            @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser") String user)
            throws ItemNotFoundException, ItemForbiddenException {
        Album deleteAlbum = findAlbumById(id, user);

        this.albumService.deleteAlbum(id);

        return deleteAlbum;
    }
}