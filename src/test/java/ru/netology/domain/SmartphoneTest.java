package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    Product first = new Smartphone(1, "Iphone 11", 60_000, "Apple");

    @Test
    void shouldMatchesSmartphoneWithRightNameSearch() {

        boolean res = this.first.matches("Iphone 11");

        assertTrue(res);
    }

    @Test
    void shouldMatchesSmartphoneWithWrongNameSearch() {

        boolean res = this.first.matches("Samsung Galaxy S20");

        assertFalse(res);
    }

    @Test
    void shouldMatchesSmartphoneWithRightManufacturerSearch() {

        boolean res = this.first.matches("Apple");

        assertTrue(res);
    }

    @Test
    void shouldMatchesSmartphoneWithWrongManufacturerSearch() {

        boolean res = this.first.matches("Samsung Electronic");

        assertFalse(res);
    }
}