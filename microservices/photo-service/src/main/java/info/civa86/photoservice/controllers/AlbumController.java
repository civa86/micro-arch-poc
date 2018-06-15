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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info.civa86.photoservice.exceptions.ItemNotFoundException;
import info.civa86.photoservice.model.Album;
import info.civa86.photoservice.service.AlbumService;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping(value = "/albums")
    public List<Album> getAlbumList() {
        return albumService.findAll();
    }

    @PostMapping(value = "/album")
    @ResponseStatus(HttpStatus.CREATED)
    public Album createAlbum(@RequestBody @Valid Album album) {
        Album newAlbum = new Album();

        newAlbum.setName(album.getName());

        this.albumService.saveAlbum(newAlbum);

        return newAlbum;

    }

    @PutMapping(value = "/album/{id}")
    public Album updateAlbum(@PathVariable(value = "id") Integer id, @RequestBody @Valid Album album) throws ItemNotFoundException{
        Album editAlbum = this.albumService.getAlbumById(id);
        if (editAlbum == null) {
            throw new ItemNotFoundException();
        }

        editAlbum.setName(album.getName());

        this.albumService.saveAlbum(editAlbum);

        return editAlbum;
    }

    @DeleteMapping(value = "/album/{id}")
    public Integer deleteAlbum(@PathVariable(value = "id") Integer id) throws ItemNotFoundException{
        Album deleteAlbum = this.albumService.getAlbumById(id);
        if (deleteAlbum == null) {
            throw new ItemNotFoundException();
        }

        this.albumService.deleteAlbum(id);

        return id;
    }
}