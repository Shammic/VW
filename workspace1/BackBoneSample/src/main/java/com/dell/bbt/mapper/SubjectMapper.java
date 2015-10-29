package com.dell.bbt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dell.bbt.model.Subject;

public interface SubjectMapper {

	@Select("SELECT * FROM SUBJECT")
	List<Subject> getAllsubject();

	@Insert("INSERT INTO subject (name,code,description) VALUES (#{name},#{code},#{description})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int saveSubject(Subject subject);

	@Update("UPDATE subject SET id = #{id},name = #{name},code = #{code},description = #{description } WHERE id = #{id}")
	int updateSubject(Subject subject);

	@Delete("DELETE FROM subject WHERE id = #{id}")
	int deleteSubject(int id);

}
