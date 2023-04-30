package ru.mpei.hw2;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.mpei.hw2.domain.Mark;
import ru.mpei.hw2.domain.Student;
import ru.mpei.hw2.repositories.MarkRepository;
import ru.mpei.hw2.repositories.StudentRepository;
import ru.mpei.hw2.service.FileService;

import java.sql.SQLException;
import java.util.List;


@SpringBootApplication
public class Hw2Application {

    public static void main(String[] args) throws SQLException {

        ConfigurableApplicationContext context = SpringApplication.run(Hw2Application.class, args);
        StudentRepository repStudent = context.getBean(StudentRepository.class);

        MarkRepository repMark = context.getBean(MarkRepository.class);
        FileService fs = context.getBean(FileService.class);

        Mark mark1 = new Mark(1,"java",2);
        repMark.save(mark1);
        repStudent.save(new Student(1,"ivan","ivanov","ivanovich",
                "8",2019, List.of(mark1)));


        Mark mark2 =new Mark(2,"python",5);
        Mark mark3 = 	new Mark(3,"java",5);
        repMark.save(mark2);
        repMark.save(mark3);
        repStudent.save(new Student(2,"alex","yakunin","vladimirovich",
                "8",2019, List.of(mark2,mark3)));

        Mark mark4 = new Mark(4,"python",3);
        repMark.save(mark4);
        repStudent.save(new Student(3,"alex1","yakunin1","vladimirovich1",
                "9",2019 , List.of(mark4)));

        Mark mark5 = new Mark(5,"java",3);
        repMark.save(mark5);
        repStudent.save(new Student(4,"vlad","vladov","michailovich",
                "9",2019 , List.of(mark5)));

        Mark mark6 = new Mark(6,"java",2);
        repMark.save(mark6);
        repStudent.save(new Student(5,"mark","borisov","olegovich",
                "9",2019 , List.of(mark6)));
        FileService averageMark = context.getBean(FileService.class);
        averageMark.Calculate("8","python");
        averageMark.Calculate("8","java");
        averageMark.Calculate("9","python");
        averageMark.Calculate("9","java");


        Console.main(args);
    }

}
