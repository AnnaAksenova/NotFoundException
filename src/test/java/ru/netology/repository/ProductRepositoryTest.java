package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book coreJava = new Book();
  Book book1 = new Book(1, "Мастер и Маргарита", 350, "М.А.Булгаков");
  Book book2 = new Book(2, "Анна Каренина", 420, "Л.Н.Толстой");
  Book book3 = new Book(3, "Преступление и наказание", 510, "Ф.М.Достоевский");

  @Test
  public void shouldSaveOneItem() {
    repository.save(coreJava);

    Product[] expected = new Product[]{coreJava};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void successfullyDeletingAnExistingElement(){
    repository.save(coreJava);

    Product[] expected = new Product[]{coreJava};
    Product[] actual = repository.findAll();
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testNotFound(){
    repository.save(book1);
    repository.save(book2);
    repository.save(book3);

    assertThrows(NotFoundException.class, () -> {
      repository.removeById(-2);
    });
  }
}
