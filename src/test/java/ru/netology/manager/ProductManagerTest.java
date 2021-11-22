package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

//    Book Tests

//    Books

    Product first = new Book(1, "Pride and Prejudice", 500, "Jane Austen");
    Product second = new Book(2, "The Green Mile", 450, "Stephen King");
    Product third = new Book(3, "Emma", 400, "Jane Austen");
    Product fourth = new Book(4, "The Double", 600, "Fedor Dostoevsky");
    Product fifth = new Book(5, "The Double", 350, "Jose Saramago");

//    Smartphones

    Product sixth = new Smartphone(6, "Iphone 11", 60_000, "Apple");
    Product seventh = new Smartphone(7, "Samsung Galaxy S20", 70_000, "Samsung Electronic");
    Product eighth = new Smartphone(8, "Iphone XR", 50_000, "Apple");

//    Hypothetical product for last test

    Product ninth = new Book (9, "Apple", 700, "Unknown");

    @Test
    void shouldSearchOneBookByAuthor() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Stephen King");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchFewBookByAuthor() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{first, third};
        Product[] actual = manager.searchBy("Jane Austen");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchOneBookByName() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("The Green Mile");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchFewBookByName() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{fourth, fifth};
        Product[] actual = manager.searchBy("The Double");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthorInEmptySet() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Jane Austen");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByNameInEmptySet() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("The Double");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByNonexistentAuthor() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Vasya Pupkin");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByNonexistentName() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Netology");

        assertArrayEquals(expected, actual);
    }

//    Smartphone Tests

//    Smartphones

//    Product sixth = new Smartphone(6, "Iphone 11", 60_000, "Apple");
//    Product seventh = new Smartphone(7, "Samsung Galaxy S20", 70_000, "Samsung Electronic");
//    Product eighth = new Smartphone(8, "Iphone XR", 50_000, "Apple");

    @Test
    void shouldSearchOneSmartphoneByManufacturer() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{seventh};
        Product[] actual = manager.searchBy("Samsung Electronic");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchFewSmartphoneByManufacturer() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{sixth, eighth};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{sixth};
        Product[] actual = manager.searchBy("Iphone 11");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByManufacturerInEmptySet() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByNameInEmptySet() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Samsung Galaxy S20");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByNonexistentManufacturer() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Peach Сorporation");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByNonexistentName() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Peachphone");

        assertArrayEquals(expected, actual);
    }

//    Last Test

    @Test
    void shouldSearchProductWithSameName() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);

        Product[] expected = new Product[]{sixth, eighth, ninth};
        Product[] actual = manager.searchBy("Apple");

        assertArrayEquals(expected, actual);
    }
}