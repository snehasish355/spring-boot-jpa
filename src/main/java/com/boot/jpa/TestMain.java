package com.boot.jpa;

import lombok.*;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TestMain {
    public static void main(String[] args) {
        LocalDateTime dbo = LocalDateTime.now();
        List<Emp> empList = Arrays.asList(Emp.builder().id(12).dob(dbo).salary(BigDecimal.ONE).name("Remo").updateTs(LocalDateTime.now()).build(),
                Emp.builder().id(13).dob(dbo).salary(BigDecimal.TWO).name("Papai").updateTs(LocalDateTime.now()).build(),
                Emp.builder().id(11).dob(dbo).salary(BigDecimal.TEN).name("Snehasish").updateTs(LocalDateTime.now()).build()
        );
        TreeMap<Integer, Student> stuMap = new TreeMap<>();
        stuMap.put(12, Student.builder().dob(dbo).stipend(BigDecimal.ONE).name("Remo").updateTs(LocalDateTime.now()).build());
        stuMap.put(13, Student.builder().id(13).dob(dbo).stipend(BigDecimal.TWO).name("Papai").updateTs(LocalDateTime.now()).build());
        stuMap.put(11, Student.builder().id(11).dob(dbo).stipend(BigDecimal.TEN).name("Snehasish").updateTs(LocalDateTime.now()).build());


        for (Emp e : empList) {
            List<Ultimate> uList = new ArrayList<>();
            Ultimate u = new Ultimate();
            Student s = stuMap.get(e.getId());
            boolean hasChanges = false;
            if (ObjectUtils.notEqual(e.getId(), s.getId())) {
                u.setId(s.getId());
                hasChanges = true;
            } else {
                u.setId(s.getId());
            }

            if (ObjectUtils.notEqual(e.getName(), s.getName())) {
                u.setName(s.getName());
                hasChanges = true;
            } else {
                u.setName(s.getName());
            }

            if (ObjectUtils.notEqual(e.getSalary(), s.getStipend())) {
                u.setStipend(s.getStipend());
                hasChanges = true;
            } else {
                u.setStipend(s.getStipend());
            }

            if (s.getDob().isEqual(e.getDob())) {
                u.setDob(s.getDob());
            } else {
                u.setDob(s.getDob());
                hasChanges = true;
            }

            if (hasChanges) {
                u.setUpdateTs(LocalDateTime.now());
                uList.add(u);
            }

            uList.forEach(ul -> System.out.println(ul.toString()));

        }


    }

}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Emp {
    private Integer id;
    private LocalDateTime dob;
    private LocalDateTime updateTs;
    private BigDecimal salary;
    private String name;
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private Integer id;
    private LocalDateTime dob;
    private LocalDateTime updateTs;
    private BigDecimal stipend;
    private String name;
}

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Ultimate {
    private Integer id;
    private LocalDateTime dob;
    private LocalDateTime updateTs;
    private BigDecimal stipend;
    private String name;
}