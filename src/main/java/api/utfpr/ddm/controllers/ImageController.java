package api.utfpr.ddm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import api.utfpr.ddm.dtos.ImageResponseDto;
import api.utfpr.ddm.models.Imagem;
import api.utfpr.ddm.services.ImagemService;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImagemService imageService;

    @PostMapping
    public ImageResponseDto createImage(@RequestParam MultipartFile file){
        return ImageResponseDto.imageDto(imageService.createImagem(file));
    }

    @GetMapping
    public List<ImageResponseDto> getAllImages(){
        List<Imagem> images = this.imageService.getAllImagems();
        List<ImageResponseDto> ImageResponseDtos = new ArrayList<>();
        for (Imagem image : images){
            ImageResponseDtos.add(ImageResponseDto.imageDto(image));
        }
        return ImageResponseDtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getImage(@PathVariable Integer id){
        Resource file = this.imageService.getImagem(id);

        if (file == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PutMapping("/{id}")
    public ImageResponseDto updateImage(@PathVariable Integer id, @RequestParam("file") MultipartFile file){
        return ImageResponseDto.imageDto(imageService.updateImagem(id, file));
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Integer id){
        this.imageService.deleteImagem(id);
    }
}
