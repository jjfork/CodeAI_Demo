package com.bestpractice.api.infrastrucuture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;

@ExtendWith(MyExtension.class)
public class InfoTest {
    @Test
    void testInfo() {
        Info info = new Info();
        assertThrows(IllegalArgumentException.class, () -> info.doSomething(""));
    }
}