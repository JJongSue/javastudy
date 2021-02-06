package week12;

public class AnnotationExam {
    public static void main(String[] args) {
        Child c = new Child();
        c.cprint();
    }
}

class Parent{
    void print(){
        System.out.println("Parent Print()!");
    }
}

class Child extends Parent{
    @Override
    void print(){
        System.out.println("Child Print()");
    }

//    @Override
    @Deprecated
    void cprint(){
        System.out.println("c print");
    }
}


