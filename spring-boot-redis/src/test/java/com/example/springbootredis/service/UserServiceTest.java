package com.example.springbootredis.service;

import com.example.springbootredis.SpringBootRedisApplicationTests;
import com.example.springbootredis.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Slf4j
public class UserServiceTest extends SpringBootRedisApplicationTests {

    @Autowired
    private StudentService studentService;

    /**
     * 获取两次，查看日志验证缓存
     */
    @Test
    public void getTwice() {
        // 模拟查询id为1的用户
        Student user1 = studentService.get(1L);
        log.debug("【user1】= {}", user1);

        // 再次查询
        Student user2 = studentService.get(1L);
        log.debug("【user2】= {}", user2);
        // 查看日志，只打印一次日志，证明缓存生效
    }

    /**
     * 先存，再查询，查看日志验证缓存
     */
    @Test
    public void getAfterSave() {
        studentService.saveOrUpdate(new Student(7L, "1009","小李子",90));

        Student user = studentService.get(4L);
        log.debug("【Student】= {}", user);
        // 查看日志，只打印保存用户的日志，查询是未触发查询日志，因此缓存生效
    }

    /**
     * 测试删除，查看redis是否存在缓存数据
     */
    @Test
    public void deleteUser() {
        // 查询一次，使redis中存在缓存数据
        studentService.get(1L);
        // 删除，查看redis是否存在缓存数据
        studentService.delete(1L);
    }
}
