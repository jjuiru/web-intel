package com.mohaji.popproject.repository;

import java.util.List;
import com.mohaji.popproject.model.Artboard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ArtboardMapper {
	
	@Select("select count(*) from artboard")
	int count();
	
	@Select("select * from artboard")
	List<Artboard> selectAllArtboard();
	
	@Select("select * from artboard where POP_CODE =#{popCode}")
	Artboard selectOneArtboard(String popCode);
	
	@Insert("INSERT INTO artboard (POP_CODE, POP_NAME, START_DAY, END_DAY, content, img, rink, place)"
			+ "VALUES (#{popCode}, #{popName}, #{startDay} , #{endDay}, #{content}, #{img}, #{rink}, #{place} )")       
	void insertArtboard(Artboard artboard);

	@Update("UPDATE artboard set POP_NAME= #{popName}, START_DAY= #{startDay}, END_DAY= #{endDay}, content=#{content}, img= #{img}, rink= #{rink}, place= #{place}"
			           +"where POP_CODE= #{popCode}")
	void updateArtboard(Artboard artboard);
	
	@Delete("delete from artboard where POP_CODE= #{popCode}")
    void deleteArtboard(String popCode);
	
}
