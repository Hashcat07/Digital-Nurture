package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "ray";
        int orderId = 1042;
        double amount = 2599.50;

        logger.info("User {} placed order {}", username, orderId);
        logger.debug("Order {} total amount is {}", orderId, amount);
        logger.warn("Low stock while processing order {} for user {}", orderId, username);

         try {
            throw new RuntimeException("Payment gateway timeout");
        } catch (Exception e) {
            logger.error("Failed to process order {} for user {}", orderId, username, e);
        }
    }
}