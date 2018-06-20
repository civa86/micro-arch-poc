package info.civa86.photoservice.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import info.civa86.photoservice.exceptions.ItemForbiddenException;
import info.civa86.photoservice.exceptions.ItemNotFoundException;
import info.civa86.photoservice.model.Picture;
import info.civa86.photoservice.service.PictureService;

@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @Autowired
    private Validator validator;

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

    @PostMapping(value = "/picture")
    @ResponseStatus(HttpStatus.CREATED)
    public Picture createPicture(@RequestParam("title") String title, @RequestParam("albumId") int albumId,
            @RequestParam("image") MultipartFile file,
            @RequestHeader(value = "auth-principal", defaultValue = "anonymousUser") String user) {
        Picture newPicture = new Picture();
        Set<ConstraintViolation<Picture>> violations;

        newPicture.setTitle(title);
        newPicture.setAlbumId(albumId);
        newPicture.setUser(user);
        violations = validator.validate(newPicture);

        System.out.println(file.getOriginalFilename());
        System.out.println(violations);

        // this.albumService.saveAlbum(newAlbum);

        return newPicture;

    }

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