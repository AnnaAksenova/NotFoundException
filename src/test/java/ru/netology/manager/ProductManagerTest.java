package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.TShirt;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


public class ProductManagerTest {
    ProductRepository productRepository = new ProductRepository();
    ProductManager productManager = new ProductManager(productRepository);

    Book book1 = new Book(1, "Мастер и Маргарита", 350, "М.А.Булгаков");
    Book book2 = new Book(2, "Анна Каренина", 420, "Л.Н.Толстой");
    Book book3 = new Book(3, "Преступление и наказание", 510, "Ф.М.Достоевский");
    Smartphone smartphone1 = new Smartphone(4, "iPhone 12 Pro", 78000, "Apple");
    Smartphone smartphone2 = new Smartphone(5, "Poco X3", 18500, "Xiaomi");
    Smartphone smartphone3 = new Smartphone(6, "Galaxy S20", 50000, "Samsung");
    TShirt tShirt = new TShirt(7, "Женская футболка", 2000, "Красная","42");

    @Test
    public void searchByAll() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);
        productManager.add(tShirt);

        assertArrayEquals(new Product[]{book1}, productManager.searchBy("М.А.Булгаков"));
        assertArrayEquals(new Product[]{smartphone3}, productManager.searchBy("Samsung"));
    }

    @Test
    public void findBookByName(){
        productManager.add(book2);

        assertArrayEquals(new Product[] {book2}, productManager.searchBy("Анна"));
    }

    @Test
    public void findSmartphoneByFabricator(){
        productManager.add(smartphone3);

        assertArrayEquals(new Product[] {smartphone3}, productManager.searchBy("Samsung") );
    }

    @Test
    public void findSmartphoneByName(){
        productManager.add(smartphone1);

        assertArrayEquals(new Product[] {smartphone1}, productManager.searchBy("iPhone 12 Pro") );
    }

    @Test
    public void findSmartphoneBy(){

        assertArrayEquals(new Product[]{}, productManager.searchBy("Xiaomi") );
    }
    @Test
    public void findBy(){
        productManager.add(smartphone1);

        assertArrayEquals(new Product[]{}, productManager.searchBy("Nokia") );
    }

    @Test
    public void findByNotNeed(){
        productManager.add(tShirt);

        assertArrayEquals(new Product[]{}, productManager.searchBy("Красная") );
    }

    @Test
    public void findZero(){
        assertArrayEquals(new Product[]{}, productManager.searchBy("Apple") );
    }
}



