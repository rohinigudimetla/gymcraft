package edu.bu.met.cs665;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SetCountHandlerTest {

    @Test
    public void testHandleSetCountRequest() {
        WorkoutPlanBuilder mockBuilder = mock(WorkoutPlanBuilder.class);
        SetCountHandler handler = new SetCountHandler(mockBuilder);

        CustomizationRequest request = new CustomizationRequest(CustomizationType.SetCount, 3);
        handler.HandleRequest(request);

        verify(mockBuilder).setNumberOfSets(3);
    }
}