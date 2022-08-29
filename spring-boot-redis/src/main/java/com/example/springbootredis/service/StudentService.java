package com.example.springbootredis.service;

import com.example.springbootredis.entity.Student;

/**
 * @description: StudentService
 * @author: panyi
 * @date Created in 2022/08/29
 **/
public interface StudentService {

    /**
     * 保存或修改用户
     *
     * @param student 用户对象
     * @return 操作结果
     */
    Student saveOrUpdate(Student student);

    /**
     * 获取学生
     *
     * @param id key值
     * @return 返回结果
     */
    Student get(Long id);

    /**
     * 删除
     *
     * @param id key值
     */
    void delete(Long id);

}
