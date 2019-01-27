package HW11;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitShopUnitTest {
    private static FruitShop fruitShop;
    private static Fruit apple;
    private static Fruit strawberry;
    private static Fruit pear;
    private static Fruit orange;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");

        apple = new Fruit(FruitType.APPLE, 10, LocalDate.of(2019, 1, 1), 10, null);
        apple = new Fruit(FruitType.APPLE, 11, LocalDate.of(2019, 1, 2), 11, null);
        strawberry = new Fruit(FruitType.STRAWBERRY, 20, LocalDate.of(2019, 2, 2), 20, null);
        pear = new Fruit(FruitType.PEAR, 30, LocalDate.of(2019, 3, 9), 30, null);
        orange = new Fruit(FruitType.ORANGE, 40, LocalDate.of(2019, 4, 1), 40, null);
    }

    @Before
    public void before() {
        System.out.println("Before test");
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(apple);
        fruits.add(strawberry);
        fruits.add(pear);
        fruits.add(orange);
        fruitShop = new FruitShop("TestShop", fruits);
    }

    @After
    public void after() {
        System.out.println("After test");
        fruitShop = null;
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Test
    public void testAllFreshApples() {
        List<Fruit> expect = new ArrayList<>();
        expect.add(apple);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 1, 9));
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testAllFreshOrange() {
        List<Fruit> expect = new ArrayList<>();
        expect.add(orange);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 5, 5));
        Assert.assertEquals(expect, actual);
    }


    @Test
    public void testReturnsNull() {
        List<Vitamins> actual = apple.getVitamins();
        System.out.println(actual);
    }


    @Test
    public void testEmptyList() {
        List<Fruit> actual = fruitShop.allFresh(LocalDate.now());
        int expected = 0;
        Assert.assertEquals(actual.size(), expected);
    }

    @Test
    public void testAtLeastDaysLivingFruits() {
        List<Fruit> expect = new ArrayList<>();
        expect.add(apple);
        expect.add(strawberry);
        expect.add(pear);
        expect.add(orange);
        List<Fruit> actual = fruitShop.checkByExpireDate(9);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testDaysLivingFruit() {
        List<Fruit> ex = new ArrayList<>();
        ex.add(orange);
        List<Fruit> actual = fruitShop.checkByExpireDate(30);
        Assert.assertEquals(ex, actual);
    }

    @Test
    public void testFreshFruitOfTypeApple() {
        List<Fruit> expect = new ArrayList<>();
        expect.add(apple);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.APPLE, LocalDate.of(2019, 1, 9));
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFreshFruitOfTypePear() {
        List<Fruit> expect = Arrays.asList(pear);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.PEAR, LocalDate.of(2019, 3, 20));
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testAppleTypeFruits() {
        List<Fruit> expect = new ArrayList<>();
        expect.add(apple);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(FruitType.APPLE);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testOrangeTypeFruits() {
        List<Fruit> expect = new ArrayList<>();
        expect.add(orange);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(FruitType.ORANGE);
        Assert.assertEquals(expect, actual);
    }
}