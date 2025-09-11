package com.multi.di.di3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;


//보일러 프레이트코드
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;


}
