package com.multi.di.di4;
//ctrl +R 누르련 치환
//alt+Enter import 자동추가


import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
@Data
public class PersonCollection {
    private List<Person> list;
    private Set<Person> set;
    private Properties properties;
    private Map<Integer, Person> map;
}
