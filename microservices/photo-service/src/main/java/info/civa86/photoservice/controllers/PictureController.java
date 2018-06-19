package info.civa86.photoservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import info.civa86.photoservice.exceptions.ItemForbiddenException;
import info.civa86.photoservice.exceptions.ItemNotFoundException;
import info.civa86.photoservice.model.Picture;
import info.civa86.photoservice.service.PictureService;

@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @GetMapping(value = "/pictures")
    public List<Picture> getPictureList(
            @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser") String user) {
        return pictureService.findAll(user);
    }

    private Picture findPictureById(Integer id, String user) throws ItemNotFoundException, ItemForbiddenException {
        Picture pic = this.pictureService.getPictureById(id);

        if (pic == null) {
            throw new ItemNotFoundException();
        }
        if (!pic.getUser().equals(user)) {
            throw new ItemForbiddenException();
        }

        return pic;
    }

    @GetMapping(value = "/picture/{id}")
    public Picture getPicture(@PathVariable(value = "id") Integer id,
            @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser") String user)
            throws ItemNotFoundException, ItemForbiddenException {
        return findPictureById(id, user);
    }

    // @PostMapping(value = "/album")
    // @ResponseStatus(HttpStatus.CREATED)
    // public Album createAlbum(@RequestBody @Valid Album album,
    // @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser")
    // String user) {
    // Album newAlbum = new Album();

    // newAlbum.setName(album.getName());
    // newAlbum.setUser(user);

    // this.albumService.saveAlbum(newAlbum);

    // return newAlbum;

    // }

    // @PutMapping(value = "/album/{id}")
    // public Album updateAlbum(@PathVariable(value = "id") Integer id, @RequestBody
    // @Valid Album album,
    // @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser")
    // String user)
    // throws ItemNotFoundException, ItemForbiddenException {
    // Album editAlbum = findAlbumById(id, user);

    // editAlbum.setName(album.getName());

    // this.albumService.saveAlbum(editAlbum);

    // return editAlbum;
    // }

    // @DeleteMapping(value = "/album/{id}")
    // public Album deleteAlbum(@PathVariable(value = "id") Integer id,
    // @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser")
    // String user)
    // throws ItemNotFoundException, ItemForbiddenException {
    // Album deleteAlbum = findAlbumById(id, user);

    // this.albumService.deleteAlbum(id);

    // return deleteAlbum;
    // }
}