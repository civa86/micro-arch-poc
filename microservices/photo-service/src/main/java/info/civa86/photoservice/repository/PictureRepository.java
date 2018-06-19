package info.civa86.photoservice.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.civa86.photoservice.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Integer> {
    @Query(value = "SELECT * FROM picture WHERE user = ?1", nativeQuery = true)
    List<Picture> findAll(String user);

    @Query(value = "SELECT * FROM picture WHERE album_id = ?1 AND user = ?2", nativeQuery = true)
    List<Picture> findByAlbumId(int albumId, String user);
}
