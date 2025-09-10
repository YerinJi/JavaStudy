package com.multi.di.di4;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
public class PersonCollection {
    private List<Person>list;
    private Set<Person>set;
    private Properties properties;
    private Map<Integer, Person>map;

}
