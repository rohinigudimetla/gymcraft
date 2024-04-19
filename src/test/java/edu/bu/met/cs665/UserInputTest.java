package edu.bu.met.cs665;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UserInputTest {

    @Test
    public void testUserInput() {
        // Simulate user input
        String simulatedInput = "Back\\n45\\n3\\n10\\nPull-ups\\nLat Pulldowns\\nSeated Cable Rows\\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Call the method that requires user input
        WorkoutPlanApp.main(null);

        // Assert the expected result
        // ... add assertions to verify the workout plan details ...
    }
}

