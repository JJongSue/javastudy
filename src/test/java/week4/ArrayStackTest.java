package week4;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    @BeforeAll
    static void beforeall(){
        System.out.println("Before All");
    }

    @AfterAll
    static void afterall(){
        System.out.println("After All");
    }

    @BeforeEach
    void beforeeach(){
        System.out.println("BeforeEach");
    }
    @AfterEach
    void aftereach(){
        System.out.println("AfterEach");
    }

    @DisplayName("테스트is_full()")
    @Test
    void is_full() {
        System.out.println("is_full");
    }

    @Test
    void is_empty() {
    }

    @Test
    void sizeUP() {
    }

    @Test
    void add() {
    }

    @Test
    void pop() {
    }
}