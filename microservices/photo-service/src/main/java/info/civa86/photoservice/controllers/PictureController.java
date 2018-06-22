package info.civa86.photoservice.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validator;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import info.civa86.photoservice.exceptions.ItemForbiddenException;
import info.civa86.photoservice.exceptions.ItemNotFoundException;
import info.civa86.photoservice.model.Picture;
import info.civa86.photoservice.service.AlbumService;
import info.civa86.photoservice.service.PictureService;

@RestController
public class PictureController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private Validator validator;

    @GetMapping(value = "/pictures")
    public List<Picture> getPictureList(@RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId) {
        return pictureService.findAll(userId);
    }

    private Picture checkPicture(Integer id, int userId) throws ItemNotFoundException, ItemForbiddenException {
        return this.pictureService.getPictureByIdAndCheckUser(id, userId);
    }

    @GetMapping(value = "/picture/{id}")
    public Picture getPicture(@PathVariable(value = "id") Integer id,
            @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId)
            throws ItemNotFoundException, ItemForbiddenException {
        return checkPicture(id, userId);
    }

    @GetMapping(value = "/picture/{id}/render")
    public void renderPicture(@PathVariable(value = "id") Integer id,
            @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId, HttpServletResponse response)
            throws ItemNotFoundException, ItemForbiddenException, IOException {
        Picture pic = checkPicture(id, userId);
        InputStream inputStream = new ByteArrayInputStream(pic.getImage());
        response.setContentType(pic.getMimeType());
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    @PostMapping(value = "/picture")
    @ResponseStatus(HttpStatus.CREATED)
    public Picture createPicture(@RequestParam("title") String title, @RequestParam("albumId") int albumId,
            @RequestParam("image") MultipartFile image,
            @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId, HttpServletResponse response)
            throws ItemNotFoundException, ItemForbiddenException, MethodArgumentNotValidException, IOException {

        Picture newPicture;
        BeanPropertyBindingResult result;
        SpringValidatorAdapter adapter;

        albumService.getAlbumByIdAndCheckUser(albumId, userId);

        newPicture = new Picture();
        newPicture.setTitle(title);
        newPicture.setMimeType(image.getContentType());
        newPicture.setImage(image.getBytes());
        newPicture.setAlbumId(albumId);
        newPicture.setUserId(userId);

        result = new BeanPropertyBindingResult(newPicture, "picture");
        adapter = new SpringValidatorAdapter(validator);
        adapter.validate(newPicture, result);

        if (result.hasErrors()) {
            response.sendError(400);
            throw new MethodArgumentNotValidException(null, result);
        }

        this.pictureService.savePicture(newPicture);

        return newPicture;

    }

    @PutMapping(value = "/picture/{id}")
    public Picture updatePicture(@PathVariable(value = "id") Integer id, @RequestBody @Valid Picture picture,
            @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId)
            throws ItemNotFoundException, ItemForbiddenException {
        Picture editPicture = checkPicture(id, userId);

        editPicture.setTitle(picture.getTitle());

        this.pictureService.savePicture(editPicture);

        return editPicture;
    }

    @DeleteMapping(value = "/picture/{id}")
    public Picture deletePicture(@PathVariable(value = "id") Integer id,
            @RequestHeader(value = "X-FORWARDED-USER-ID", defaultValue = "-1") int userId)
            throws ItemNotFoundException, ItemForbiddenException {
        Picture deletePicture = checkPicture(id, userId);

        this.pictureService.deletePicture(id);

        return deletePicture;
    }
}