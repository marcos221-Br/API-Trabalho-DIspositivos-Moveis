package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.Imagem;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ImageResponseDto {
    
    private Integer id;
    private String imagem;

    public static ImageResponseDto imageDto(Imagem image){
        try{
            return new ImageResponseDto(image.getId(),image.getImagem());
        }catch(NullPointerException e){
            return null;
        }
    }
}
