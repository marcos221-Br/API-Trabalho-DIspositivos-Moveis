package api.utfpr.ddm.dtos;

import java.util.ArrayList;
import java.util.List;

import api.utfpr.ddm.models.Car;
import api.utfpr.ddm.models.CarImage;
import api.utfpr.ddm.models.Image;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CarImageDto {
    
    private Car carro;
    private List<Image> imagens;

    public List<CarImage> carImageObject(){
        List<CarImage> carImages = new ArrayList<>();
        for(Image image : imagens){
            carImages.add(new CarImage(carro, image));
        }
        return carImages;
    }
}
