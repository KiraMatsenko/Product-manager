import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.product.manager.product.item.Book;
import ru.netology.product.product.manager.product.item.Smartphone;
import ru.netology.product.product.manager.product.item.Product;
import ru.netology.product.product.manager.product.product.repo.ProductRepository;
import ru.netology.product.product.manager.service.ProductManager;

public class ManagerAndRepoTests {

    ProductRepository repo = new ProductRepository();
    Product item = new Product();
    ProductManager manager = new ProductManager(repo);
    Product product = new Product();

    Product item1 = new Book(1, "Книга 1", 100, "Автор 1");
    Product item2 = new Book(2, "Книга 2", 200, "Автор 2");
    Product item3 = new Smartphone(3, "Смартфон 1", 1000, "Бренд 1");
    Product item4 = new Smartphone(4, "Смартфон 2", 2000, "Бренд 2");

    @Test
    public void repoShouldAddItem() {
        repo.add(item1);

        Product[] expected = {item1};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repoShouldShowRepoContent() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);

        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void repoShouldDeleteById() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);
        repo.deleteById(4);

        Product[] expected = {item1, item2, item3};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //здесь и ниже тесты на менеджер
    public void managerShouldAddToRepo() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {item1, item2, item3, item4};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void managerShouldSearchById() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);

        Product[] expected = {item1};
        Product[] actual = manager.searchByText("Книга 1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void productShouldReturnTrue() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);

        Product[] expected = {item3};
        Product[] actual = manager.searchByText("Смартфон 1");
    }

    @Test
    public void productShouldReturnFalse() {}

    @Test
    public void smartphoneShouldReturnTrue() {
        Smartphone smartphone = new Smartphone();
        smartphone.setName("Смартфон 1");
        smartphone.setBrand("Бренд 1");
        boolean expected = true;
        boolean actual = smartphone.matches("Бренд 1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void managerShouldSearchByText() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);

        Product[] expected = {item3};
        Product[] actual = manager.searchByText("Бренд 1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void productShouldReturnTrue1() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);
        repo.add(item4);

        boolean expected = true;
        boolean actual = product.matches("Смартфон 1");

        Assertions.assertEquals(expected, actual);
    }
}
