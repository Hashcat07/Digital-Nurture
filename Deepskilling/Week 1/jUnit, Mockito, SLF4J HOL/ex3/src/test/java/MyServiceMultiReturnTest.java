package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.ExternalApi;
import org.example.MyService;
import org.junit.jupiter.api.Test;

public class MyServiceMultiReturnTest {

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData())
                .thenReturn("First")
                .thenReturn("Second");

        MyService service = new MyService(mockApi);

        assertEquals("First", service.fetchData());   // first call
        assertEquals("Second", service.fetchData());   // second call
        assertEquals("Second", service.fetchData());   // last value sticks
    }
}