package info.civa86.photoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.civa86.photoservice.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
