package com.example.springbootmybaits.mapper;

import com.example.springbootmybaits.entity.Student;
import com.example.springbootmybaits.entity.StudentCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

/**
 * 
 * student
 */
@Mapper
public interface StudentMapper {
    long countByExample(StudentCriteria example);

    int deleteByExample(StudentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExampleWithRowbounds(StudentCriteria example, RowBounds rowBounds);

    List<Student> selectByExample(StudentCriteria example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentCriteria example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentCriteria example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}