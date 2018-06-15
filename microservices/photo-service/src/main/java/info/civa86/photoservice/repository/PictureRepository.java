package info.civa86.photoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.civa86.photoservice.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Integer> {

}
