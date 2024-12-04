package api.utfpr.ddm.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import api.utfpr.ddm.configs.StorageConfig;
import api.utfpr.ddm.exceptions.AlreadyExistsException;
import api.utfpr.ddm.exceptions.StorageException;
import api.utfpr.ddm.exceptions.StorageFileNotFoundException;
import api.utfpr.ddm.models.Image;
import api.utfpr.ddm.repositories.ImageRepository;

@Service
public class ImageService {
    
    @Autowired
    private ImageRepository imageRepository;

    private final Path rootLocation;

    public ImageService(StorageConfig properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

    public void createDirectory() {
		try {
			Files.createDirectories(rootLocation);
		}
		catch (IOException e) {
			throw new StorageException("Não foi possível inicializar o diretório");
		}
	}

    @SuppressWarnings("null")
    public Image createImage(MultipartFile file) {
        Image image = new Image();
		Path destinationFile = this.rootLocation.resolve(System.currentTimeMillis()+"."+file.getContentType().split("/")[1]).normalize().toAbsolutePath();
		try (InputStream inputStream = file.getInputStream()) {
			Files.copy(inputStream, destinationFile);
            image.setImage(destinationFile.getFileName()+"");
            return this.imageRepository.save(image);
		}catch (Exception e) {
			throw new AlreadyExistsException("Imagem duplicada enviada");
		}
	}

    public Image updateImage(Integer id, MultipartFile file){
        Image image = this.imageRepository.getReferenceById(id);
        Path destinationFile = this.rootLocation.resolve(image.getImage()).normalize().toAbsolutePath();
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            return image;
        }catch (IOException e) {
            throw new StorageException("Falha ao armazenar imagem");
        }
    }

    public List<Image> getAllImages(){
        return this.imageRepository.findAll();
    }

    public Resource getImage(Integer id){
        try {
            Path file = rootLocation.resolve(this.imageRepository.getReferenceById(id).getImage());
            Resource resource = new UrlResource(file.toUri());
            return resource;
        }catch (MalformedURLException e){
            throw new StorageFileNotFoundException("Imagem não encontrada");
        }
    }

    public void deleteImage(Integer id){
        this.imageRepository.deleteById(id);
    }
}
