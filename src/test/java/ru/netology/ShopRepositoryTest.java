package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(1, "Ручка", 199);
    Product product2 = new Product(2, "Ластик", 87);
    Product product3 = new Product(3, "Корректор", 164);


    @Test
    public void testAddProduct() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = { product1, product2, product3 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testDeleteProduct() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(1);

        Product[] expected = { product2, product3 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () ->
            repo.remove(12)
        );


}
}