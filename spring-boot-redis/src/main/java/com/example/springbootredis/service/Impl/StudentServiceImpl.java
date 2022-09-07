package com.example.springbootredis.service.Impl;

import com.example.springbootredis.entity.Student;
import com.example.springbootredis.service.StudentService;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description: StudentService 实现类
 * @author: panyi
 * @date Created in 2022/08/29
 **/
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    /**
     * 模拟数据库
     */
    private static final Map<Long, Student> DATABASES = Maps.newConcurrentMap();


    // 初始化数据
    static {
        DATABASES.put(1L, new Student(1L, "1001","小李飞刀",89));
        DATABASES.put(2L, new Student(2L, "1002","小刚",19));
        DATABASES.put(3L, new Student(3L, "1003","小红",20));
        DATABASES.put(4L, new Student(4L, "1004","ikun",13));
        DATABASES.put(5L, new Student(5L, "1005","坤坤",21));
    }

    /**
     * 保存或更新
     *
     * @param student 学生
     * @return {@link Student}
     */
    @Override
    public Student saveOrUpdate(Student student) {
        DATABASES.put(student.getId(), student);
        log.info("保存学生【student】= {}", student);
        return student;
    }

    /**
     * 获取学生信息
     *
     * @param id id
     * @return {@link Student}
     */
    @Override
    public Student get(Long id) {
        Student student = DATABASES.get(id);
        log.info("查找学生【student】:{}", student);
        return student;
    }


    /**
     * 删除学生信息
     *
     * @param id id
     */
    @Override
    public void delete(Long id) {
        DATABASES.remove(id);
        log.info("删除学生【id】= {}", id);
    }
}
