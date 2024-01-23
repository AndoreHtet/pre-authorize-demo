package com.example.preauthorizedemo.service;

import com.example.preauthorizedemo.model.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private Map<String, Employee> records =
            Map.of("john",
                    new Employee("John Doe",
                            List.of("Karamazov Brothers"),
                            List.of("accountant","reader")),
                    "mary",
                    new Employee("Mary Shelly",
                            List.of("Beautiful Paris"),
                            List.of("researcher")));

    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name){
        return records.get(name);
    }
}
