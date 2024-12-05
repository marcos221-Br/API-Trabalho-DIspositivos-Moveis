package api.utfpr.ddm.dtos;

import api.utfpr.ddm.models.Image;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ImageResponseDto {
    
    private Integer id;
    private String image;

    public static ImageResponseDto imageDto(Image image){
        try{
            return new ImageResponseDto(image.getId(),image.getImage());
        }catch(NullPointerException e){
            return null;
        }
    }
}
