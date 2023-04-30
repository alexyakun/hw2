package ru.mpei.hw2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mpei.hw2.domain.Mark;
import ru.mpei.hw2.domain.Student;
import ru.mpei.hw2.repositories.StudentRepository;

import java.util.List;

@Service
public class FileService {

    @Autowired
    private StudentRepository studRep;

    public void Calculate(String group, String course){
        List<Student> students = studRep.findByGroup(group);
        double sum = 0;
        double count = 0;
        for(Student st:students){
            List<Mark> marks = st.getMarks();
            for(Mark mark: marks){
                if(mark.getCourse_name().equals(course)){
                    sum+=mark.getValue();
                    count+=1;
                }
            }
        }
        if(count > 0 ){

            System.out.println("Средняя оценка для группы "+group+" по курсу "+course+" = " + sum/count);
        }
        else {
            System.out.println("Нет оценок для группы "+ group+ " по курсу "+course);
        }
    }

}
