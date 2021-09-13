package org.aprikhodskiy.otusintegration.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Employee {
    private String name;
    private GradeEnum grade;
    private Integer springLevel;

    @Override
    public String toString() {
        return String.format("%s (Grade: %s)", name, grade);
    }
}
