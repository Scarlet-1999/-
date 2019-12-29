package com.briup.school.service.Impl;

import com.briup.school.bean.Course;
import com.briup.school.bean.CourseExample;
import com.briup.school.mapper.CourseMapper;
import com.briup.school.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
@Autowired
private CourseMapper courseMapper;
    @Override
    public List<Course> selectAll() {
        CourseExample example =new CourseExample();
      List<Course> courses=  courseMapper.selectByExample(example);
        return courses;
    }

    @Override
    public void deleteById(int id) {
        courseMapper.deleteByPrimaryKey(id);

    }

    @Override
    public void saveOrUpdate(Course course) {
        if (course==null){
            throw  new RuntimeException("参数为空");
        }
        if(course.getId()==null){
            courseMapper.insert(course);}
        else{courseMapper.updateByPrimaryKey(course);}
    }

    @Override
    public void batchDelete(List<Course> courses) throws RuntimeException {

    }


}
