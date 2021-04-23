package com.xuren.demo.exampleannotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Inherited
public @interface CustomDescriptions {
    CustomDescription[] value();
}
