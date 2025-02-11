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
import api.utfpr.ddm.models.Imagem;
import api.utfpr.ddm.repositories.ImagemRepository;

@Service
public class ImagemService {
    
    @Autowired
    private ImagemRepository imagemRepository;

    private final Path rootLocation;

    public ImagemService(StorageConfig properties) {
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

    public Imagem createImagem(MultipartFile file) {
        Imagem imagem = new Imagem();
        Path destinationFile = this.rootLocation.resolve(System.currentTimeMillis()+"."+file.getContentType().split("/")[1]).normalize().toAbsolutePath();
        try(InputStream inputStream = file.getInputStream()){
            Files.copy(inputStream, destinationFile);
            imagem.setImagem(destinationFile.getFileName()+"");
            return this.imagemRepository.save(imagem);
        }catch(IOException e) {
            throw new AlreadyExistsException("Imagem duplicada enviada!");
        }
	}

    public Imagem updateImagem(Integer id, MultipartFile file){
        Imagem imagem = this.imagemRepository.getReferenceById(id);
        Path destinationFile = this.rootLocation.resolve(imagem.getImagem()).normalize().toAbsolutePath();
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            return imagem;
        }catch (IOException e) {
            throw new StorageException("Falha ao armazenar imagem");
        }
    }

    public List<Imagem> getAllImagems(){
        return this.imagemRepository.findAll();
    }

    public Resource getImagem(Integer id){
        try {
            Path file = rootLocation.resolve(this.imagemRepository.getReferenceById(id).getImagem());
            Resource resource = new UrlResource(file.toUri());
            return resource;
        }catch (MalformedURLException e){
            throw new StorageFileNotFoundException("Imagem não encontrada");
        }
    }

    public void deleteImagem(Integer id){
        this.imagemRepository.deleteById(id);
    }
}
