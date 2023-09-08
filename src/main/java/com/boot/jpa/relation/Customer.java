package com.boot.jpa.relation;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Table
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int customerId;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<PhoneNumber> numbers;

    public void addPhoneNumber(PhoneNumber number) {

        if (number != null) {
            if (numbers == null) {
                numbers = new HashSet<>();
            }
            number.setCustomer(this);
            numbers.add(number);
        }

    }
}
