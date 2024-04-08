package com.mohaji.popproject.service;


import com.mohaji.popproject.model.Artboard;
import com.mohaji.popproject.repository.ArtboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service 
public class ArtboardService {

    @Autowired
    private ArtboardMapper artboardMapper;
    
    public List<Artboard> artboardList() {
        return artboardMapper.selectAllArtboard(); }
    
    public Artboard artboardSelectCode(String popCode) {
        return artboardMapper.selectOneArtboard(popCode); }

}
