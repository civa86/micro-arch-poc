package info.civa86.photoservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.civa86.photoservice.exceptions.ItemForbiddenException;
import info.civa86.photoservice.exceptions.ItemNotFoundException;
import info.civa86.photoservice.model.Picture;
import info.civa86.photoservice.repository.PictureRepository;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public List<Picture> findAll(int userId) {
        List<Picture> pictures = pictureRepository.findAll(userId);
        return pictures;
    }

    public List<Picture> findPicturesByAlbumId(int albumId, int userId) {
        List<Picture> pictures = pictureRepository.findByAlbumId(albumId, userId);
        return pictures;
    }

    public void savePicture(Picture picture) {
        pictureRepository.save(picture);
    }

    public Picture getPictureByIdAndCheckUser(int id, int userId) throws ItemNotFoundException, ItemForbiddenException {
        Optional<Picture> pic = pictureRepository.findById(id);

        if (!pic.isPresent()) {
            throw new ItemNotFoundException();
        }
        if (pic.get().getUserId() != userId) {
            throw new ItemForbiddenException();
        }

        return pic.get();
    }

    public void deletePicture(Integer id) {
        pictureRepository.deleteById(id);
    }

}
