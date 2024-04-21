package edu.bu.met.cs665;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class RepCountHandlerTest {

    @Test
    public void testHandleRepCountRequest() {
        WorkoutPlanBuilder mockBuilder = mock(WorkoutPlanBuilder.class);
        RepCountHandler handler = new RepCountHandler(mockBuilder);

        CustomizationRequest request = new CustomizationRequest(CustomizationType.RepCount, 10);
        handler.HandleRequest(request);

        verify(mockBuilder).setRepetitions(10);
    }
}