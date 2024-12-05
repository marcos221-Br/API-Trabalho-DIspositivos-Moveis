package api.utfpr.ddm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.utfpr.ddm.dtos.FeatureDto;
import api.utfpr.ddm.dtos.FeatureResponseDto;
import api.utfpr.ddm.models.Feature;
import api.utfpr.ddm.services.FeatureService;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {
    
    @Autowired
    private FeatureService featureService;

    @PostMapping
    public List<FeatureResponseDto> createFeature(@RequestBody FeatureDto featureDto){
        List<FeatureResponseDto> featureResponseDtos = new ArrayList<>();
        for(Feature feature : featureDto.featureObject()){
            featureResponseDtos.add(FeatureResponseDto.featureDto(this.featureService.createFeature(feature)));
        }
        return featureResponseDtos;
    }

    @GetMapping("/{car}")
    public List<FeatureResponseDto> getFeatures(@PathVariable Integer car){
        List<FeatureResponseDto> featureResponseDtos = new ArrayList<>();
        List<Feature> features = this.featureService.getFeatures(car);
        for(Feature feature : features){
            featureResponseDtos.add(FeatureResponseDto.featureDto(feature));
        }
        return featureResponseDtos;
    }

    @PutMapping("/{id}")
    public FeatureResponseDto updateFeature(@PathVariable Integer id, @RequestBody FeatureDto featureDto){
        return FeatureResponseDto.featureDto(this.featureService.updateFeature(id, featureDto.featureObject().getFirst()));
    }

    @DeleteMapping("/{id}")
    public void deleteFeature(@PathVariable Integer id){
        this.featureService.deleteFeature(id);
    }
}
