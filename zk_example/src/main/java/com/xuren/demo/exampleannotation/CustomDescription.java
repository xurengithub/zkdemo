package com.xuren.demo.exampleannotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Repeatable(CustomDescriptions.class)
public @interface CustomDescription {
    String description() default "";
}
