package org.aprikhodskiy.otusintegration.integration;

import org.aprikhodskiy.otusintegration.domain.Employee;
import org.springframework.stereotype.Component;

@Component

public class AppraisalReview {
    public Employee review(Employee employee) {
        System.out.println(employee);
        return employee;
    }
}
