package info.civa86.photoservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.civa86.photoservice.model.Album;
import info.civa86.photoservice.repository.AlbumRepository;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> findAll() {
        List<Album> albums = albumRepository.findAll();
        return albums;
    }

    public void saveAlbum(Album album) {
        albumRepository.save(album);
    }

    public Album getAlbumById(Integer id) {
        Optional<Album> album = albumRepository.findById(id);
        return album.isPresent() ? album.get() : null;
    }

    public void deleteAlbum(Integer id) {
        albumRepository.deleteById(id);
    }

}
