package info.civa86.photoservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.civa86.photoservice.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    @Query(value = "SELECT * FROM album WHERE user = ?1", nativeQuery = true)
    List<Album> findAll(String user);
}
