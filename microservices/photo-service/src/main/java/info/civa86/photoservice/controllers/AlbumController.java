package info.civa86.photoservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}