package week12;

import java.lang.annotation.*;


public class DefaineAnnotation {
    public static void main(String[] args) {
        Annotation a[] = PracticeAnnotation.class.getAnnotations();
        for (Annotation tmp :
                a) {
            System.out.println(tmp.toString());
        }
    }
}

@Myannotation
@MyAnnotation1(name = "first", value = 1, type = "class",array = {3,7,2,1})
@Myannotation2
//@Myannotation2(name = "hello")
class PracticeAnnotation{

}

@Retention(RetentionPolicy.CLASS)
@interface Myannotation{

}

@interface MyAnnotation1{
    String name() default  "myannotation1";
    int value();
    String type() default "default";
    int[] array() default {1,2,3};
}
//@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Myannotation2{
    String name() default "hello";
}

