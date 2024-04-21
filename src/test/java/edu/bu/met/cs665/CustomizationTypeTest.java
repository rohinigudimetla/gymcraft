package edu.bu.met.cs665;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomizationTypeTest {

    @Test
    public void testEnumValues() {
        CustomizationType[] expectedValues = {
                CustomizationType.SetCount,
                CustomizationType.Duration,
                CustomizationType.RepCount,
                CustomizationType.FetchExercises
        };

        CustomizationType[] actualValues = CustomizationType.values();

        assertEquals(expectedValues.length, actualValues.length);

        for (int i = 0; i < expectedValues.length; i++) {
            assertEquals(expectedValues[i], actualValues[i]);
        }
    }
}