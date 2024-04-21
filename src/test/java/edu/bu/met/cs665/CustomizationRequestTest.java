package edu.bu.met.cs665;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomizationRequestTest {

    @Test
    public void testCustomizationRequestConstructorForSetCount() {
        CustomizationType type = CustomizationType.SetCount;
        int value = 3;

        CustomizationRequest request = new CustomizationRequest(type, value);

        assertEquals(type, request.getType());
        assertEquals(value, request.getValue());
    }

    @Test
    public void testCustomizationRequestConstructorForDuration() {
        CustomizationType type = CustomizationType.Duration;
        int value = 45;

        CustomizationRequest request = new CustomizationRequest(type, value);

        assertEquals(type, request.getType());
        assertEquals(value, request.getValue());
    }

    @Test
    public void testCustomizationRequestConstructorForRepCount() {
        CustomizationType type = CustomizationType.RepCount;
        int value = 10;

        CustomizationRequest request = new CustomizationRequest(type, value);

        assertEquals(type, request.getType());
        assertEquals(value, request.getValue());
    }

    @Test
    public void testCustomizationRequestConstructorForFetchExercises() {
        CustomizationType type = CustomizationType.FetchExercises;
        Object value = null; // FetchExercises doesn't require a value

        CustomizationRequest request = new CustomizationRequest(type, value);

        assertEquals(type, request.getType());
        assertNull(request.getValue());
    }
}
