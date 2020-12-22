package com.southwind.converter;

import com.southwind.entity.Student;
import org.springframework.core.convert.converter.Converter;

public class StudentConverter implements Converter<String, Student> {
    @Override
    public Student convert(String s) {
        String[] args = s.split("-");
        Student stu = new Student();
        stu.setId(Long.parseLong(args[0]));
        stu.setName(args[1]);
        stu.setAge(Integer.parseInt(args[2]));
        return stu;
    }
}
