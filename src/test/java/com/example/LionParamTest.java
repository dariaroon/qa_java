package com.example;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParamTest extends TestCase {

    private final String sex;
    private final boolean expectedHasMane;
    @Mock
    private Feline feline;
    private Lion lion;

    public LionParamTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }


    @Parameterized.Parameters(name = "Тестирование пола льва. Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(feline, sex);
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
