package info.civa86.photoservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.civa86.photoservice.exceptions.ItemForbiddenException;
import info.civa86.photoservice.exceptions.ItemNotFoundException;
import info.civa86.photoservice.model.Album;
import info.civa86.photoservice.repository.AlbumRepository;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> findAll(int userId) {
        List<Album> albums = albumRepository.findAll(userId);
        return albums;
    }

    public void saveAlbum(Album album) {
        albumRepository.save(album);
    }

    public Album getAlbumByIdAndCheckUser(int id, int userId) throws ItemNotFoundException, ItemForbiddenException{
        Optional<Album> album = albumRepository.findById(id);

        if (!album.isPresent()) {
            throw new ItemNotFoundException();
        }
        if (album.get().getUserId() != userId) {
            throw new ItemForbiddenException();
        }

        return album.get();
    }

    public void deleteAlbum(Integer id) {
        albumRepository.deleteById(id);
    }

}
