package org.aprikhodskiy.otusintegration.integration;

import org.aprikhodskiy.otusintegration.domain.Employee;
import org.aprikhodskiy.otusintegration.domain.GradeEnum;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class OtusTeacher {
    public Collection<Employee> teach(Collection<Employee> students) {
        for (Employee student : students
        ) {
            GradeEnum currentGrade = student.getGrade();
            student.setGrade(currentGrade.next());
        }
        return students;
    }
}
