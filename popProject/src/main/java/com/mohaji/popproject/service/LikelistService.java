package com.mohaji.popproject.service;


import com.mohaji.popproject.model.Artboard;
import com.mohaji.popproject.model.Likelist;
import com.mohaji.popproject.repository.ArtboardMapper;
import com.mohaji.popproject.repository.LikelistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service 
public class LikelistService {

    @Autowired
    private LikelistMapper likelistMapper;
    @Autowired
    private ArtboardMapper artboardMapper;


	public int countPopCode(String popCode){
		int count=likelistMapper.countByPopCode(popCode);
		return count;
	}
    public String insertDeleteLike(String status, String userId,String popCode) {
    	if(status.equals("off")) {
    		likelistMapper.deleteLikelist(userId, popCode);
    		return "off";
    	}else if(status.equals("on")){
    		if(checkLike(userId, popCode)=="on")
    		return checkLike(userId, popCode);
    		likelistMapper.insertLikelist(userId, popCode);
    		return "on";
    	} System.out.println("값이 없어요");
		return popCode;
    }
    
    public String checkLike (String userId, String popCode){
    	List<Likelist> list= likelistMapper.selectAllLikelist();
    	for(Likelist value: list) {
    		if(userId.equals(value.getUserId())&&popCode.equals(value.getPopCode())){
    			return "on";
    		}
    	}
    	return "off";
    }
    
    public List mylikeList (String userId){
    	List<Likelist> list= likelistMapper.selectUserLikelist(userId);
    	System.out.println(list);
    	List<Artboard> myList=new ArrayList<>();
    	for(Likelist value: list) {
    		System.out.println(value);
    		Artboard artboard=artboardMapper.selectOneArtboard(value.getPopCode());
    		myList.add(artboard);
    		}
    	return myList;
    	}
    
    public void mylikeListDelete (String userId, String popCode){
    	likelistMapper.deleteLikelist(userId, popCode);
    		}
    }

  
