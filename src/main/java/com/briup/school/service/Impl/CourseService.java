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

    @Override
    public List<Course> selectByKW(String key, String word) throws RuntimeException {
        word = word == null ? "" : word;
        if ((key == null || "".equals(key) ) && (word == null || "".equals(word))){
            return selectAll();
        }
        // key 为空    word不为空 表示 下拉框没有选择，后面的输入框有内容
         else if((key == null || "".equals(key)) && !"".equals(word) ) {
            word = "%" + word  + "%";
            return  courseMapper.selectIdOrName(word);

            // 下拉框选择了标题就根据标题查询
        } else if ("id".equals(key)) {
            word = "%" + word  + "%";
            return courseMapper.selectId(word);

            // 下拉框选择了作者就根据作者查询
        } else if("name".equals(key)) {
            word = "%" + word  + "%";
            return  courseMapper.selectName(word);
        }
        return null;
    }


}
