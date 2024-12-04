package api.utfpr.ddm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utfpr.ddm.models.Feature;
import api.utfpr.ddm.repositories.FeatureRepository;

@Service
public class FeatureService {
    
    @Autowired
    private FeatureRepository featureRepository;

    public Feature createFeature(Feature feature){
        return this.featureRepository.save(feature);
    }

    public List<Feature> getAllFeatures(){
        return this.featureRepository.findAll();
    }

    public List<Feature> getFeatures(Integer car){
        return this.featureRepository.findByCar(car);
    }

    public Feature updateFeature(Integer id, Feature feature){
        feature.setId(id);
        return this.featureRepository.save(feature);
    }

    public void deleteFeature(Integer id){
        this.featureRepository.deleteById(id);
    }
}
