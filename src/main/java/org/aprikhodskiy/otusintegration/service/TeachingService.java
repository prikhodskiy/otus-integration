package org.aprikhodskiy.otusintegration.service;

import lombok.AllArgsConstructor;
import org.aprikhodskiy.otusintegration.domain.Employee;
import org.aprikhodskiy.otusintegration.domain.GradeEnum;
import org.aprikhodskiy.otusintegration.integration.TeachingFlowConfiguration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
@AllArgsConstructor
public class TeachingService {
    private final TeachingFlowConfiguration.OtusCourse course;

    public void start() {
        course.make(formGroup(5));
    }

    private Collection<Employee> formGroup(int studentsCount) {
        Collection<Employee> employees = new ArrayList<>(studentsCount);

        for (int i = 1; i <= studentsCount; i++) {
            employees.add(Employee.builder().name("Student " + i).grade(GradeEnum.getRandom()).build());
        }
        return employees;
    }
}
