package com.example.springbootmybatisplus.mapper;

import com.example.springbootmybatisplus.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author PanYi
* @since 2022-08-07
*/
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
