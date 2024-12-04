package api.utfpr.ddm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.utfpr.ddm.models.Image;

public interface ImageRepository extends JpaRepository<Image,Integer>{

}
