package info.civa86.photoservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.civa86.photoservice.model.Picture;
import info.civa86.photoservice.repository.PictureRepository;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public List<Picture> findAll(String user) {
        List<Picture> pictures = pictureRepository.findAll(user);
        return pictures;
    }

    // public void saveAlbum(Album album) {
    // albumRepository.save(album);
    // }

    public Picture getPictureById(Integer id) {
        Optional<Picture> pic = pictureRepository.findById(id);
        return pic.isPresent() ? pic.get() : null;
    }

    // public void deleteAlbum(Integer id) {
    // albumRepository.deleteById(id);
    // }

}
