package com.mysite.sbb;

import lombok.Getter; // Setter
import lombok.RequiredArgsConstructor;
/*
        RequiredArgsCounstructor ==
        public HelloLombok(String hello, int lombok) {
        this.hello = hello;
        this.lombok = lombok;
    }
 */


@RequiredArgsConstructor
@Getter
public class HelloLombok {
    
    private final String hello;
    private final int lombok;

    public static void main(String args[]) {
        HelloLombok helloLombok = new HelloLombok("헬로", 1);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
