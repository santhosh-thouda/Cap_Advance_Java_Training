package com.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PriceServiceTest {

    // MOB product
    @Test
    void testCalculateFinalPrice_MOB() {

        // Mock repository
        DiscountRepository mockRepo =
                Mockito.mock(DiscountRepository.class);

        // Define behavior
        when(mockRepo.getDiscountPercentage("MOB"))
                .thenReturn(10.0);

        // Inject mock into service
        PriceService service =
                new PriceService(mockRepo);

        double finalPrice =
                service.calculateFinalPrice(1000, "MOB");

        assertEquals(900.0, finalPrice);

        // Verify method call
        verify(mockRepo).getDiscountPercentage("MOB");
    }

    // ✅ Test 2: LAP product
    @Test
    void testCalculateFinalPrice_LAP() {

        DiscountRepository mockRepo =
                mock(DiscountRepository.class);

        when(mockRepo.getDiscountPercentage("LAP"))
                .thenReturn(20.0);

        PriceService service =
                new PriceService(mockRepo);

        double finalPrice =
                service.calculateFinalPrice(2000, "LAP");

        assertEquals(1600.0, finalPrice);

        verify(mockRepo).getDiscountPercentage("LAP");
    }

    // Exception case
    @Test
    void testRepositoryThrowsException() {

        DiscountRepository mockRepo =
                mock(DiscountRepository.class);

        when(mockRepo.getDiscountPercentage("ERR"))
                .thenThrow(new RuntimeException("DB Error"));

        PriceService service =
                new PriceService(mockRepo);

        assertThrows(RuntimeException.class, () -> {
            service.calculateFinalPrice(1000, "ERR");
        });

        verify(mockRepo).getDiscountPercentage("ERR");
    }
}
