package ru.netology.manager;


import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book first = new Book(1, "Книга Тарас Бульба", 200, "Гоголь");
    private Smartphone second = new Smartphone(2, "Смартфон S30", 20000, "Samsung");
    private Book third = new Book(3, "Книга Война и мир", 250, "Толстой");
    private Smartphone fourth = new Smartphone(4, "Смартфон Redmi", 20000, "Xiaomi");
    private Book fifth = new Book(5, "Книга Мертвые души", 220, "Гоголь");
    private Smartphone sixth = new Smartphone(6, "Смартфон Blade 20", 18000, "ZTE");

    @Test
    void getAll() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);


        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void add() {

        manager.add(first);
        manager.add(second);

        Product[] expected = new Product[]{first, second};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    void searchByNameProductBook() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] expected = new Product[]{first, third, fifth};
        assertArrayEquals(expected, manager.searchBy("Книга"));
    }

    @Test
    void searchByNameProductSmartphone() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] expected = new Product[]{second, fourth, sixth};
        assertArrayEquals(expected, manager.searchBy("Смартфон"));
    }

    @Test
    void searchByNameProductTable() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);

        Product[] expected = new Product[]{};
        assertArrayEquals(expected, manager.searchBy("Стол"));
    }

}