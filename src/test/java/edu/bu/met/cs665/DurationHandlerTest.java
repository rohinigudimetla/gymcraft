package edu.bu.met.cs665;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class DurationHandlerTest {

    @Test
    public void testHandleDurationRequest() {
        WorkoutPlanBuilder mockBuilder = mock(WorkoutPlanBuilder.class);
        DurationHandler handler = new DurationHandler(mockBuilder);

        CustomizationRequest request = new CustomizationRequest(CustomizationType.Duration, 45);
        handler.HandleRequest(request);

        verify(mockBuilder).setDuration(45);
    }
}