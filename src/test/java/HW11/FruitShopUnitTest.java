package HW11;

import org.junit.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FruitShopUnitTest {
    private FruitShop fruitShop;
    private static Fruit apple;
    private static Fruit strawberry;
    private static Fruit pear;
    private static Fruit orange;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass");
        apple = new Fruit(FruitType.APPLE, 10, LocalDate.of(2019, 1, 1), 10, null);
        apple = new Fruit(FruitType.APPLE, 11, LocalDate.of(2019, 1, 2), 11, null);
        strawberry = new Fruit(FruitType.STRAWBERRY, 20, LocalDate.of(2019, 2, 2), 20, null);
        pear = new Fruit(FruitType.PEAR, 30, LocalDate.of(2019, 3, 9), 30, null);
        orange = new Fruit(FruitType.ORANGE, 40, LocalDate.of(2019, 4, 1), 40, null);
    }

    @Before
    public void before() {
        System.out.println("Before");
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(apple);
        fruits.add(strawberry);
        fruits.add(pear);
        fruits.add(orange);
        fruitShop = new FruitShop("TestShop", fruits);
    }

    @After
    public void after() {
        System.out.println("After");
        fruitShop = null;
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

    @Test
    public void testAllFresh() {
        System.out.println("Test all fresh 1");
        List<Fruit> expect = new ArrayList<>();
        expect.add(apple);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 1, 9));
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testAllFresh2() {
        System.out.println("Test all fresh 2");
        List<Fruit> expect = new ArrayList<>();
        expect.add(orange);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 5, 5));
        Assert.assertEquals(expect, actual);
    }


    @Test(expected = NullPointerException.class)
    public void testAllReturnNothing() {
        System.out.println("Test All Return Nothing");
        fruitShop.allFresh(null);
    }

    @Test
    public void testEmptyList() {
        System.out.println("Test Empty");
        List<Fruit> expect = new ArrayList<>();
        expect.add(pear);
        expect.add(orange);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 4, 5));
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testToLiveShort() {
        System.out.println("Test to live short");
        List<Fruit> expect = new ArrayList<>();
        expect.add(apple);
        expect.add(strawberry);
        expect.add(pear);
        expect.add(orange);
        List<Fruit> actual = fruitShop.checkByExpireDate(9);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testToLiveLong() {
        System.out.println("Test to live long");
        List<Fruit> ex = new ArrayList<>();
        ex.add(orange);
        List<Fruit> actual = fruitShop.checkByExpireDate(30);
        Assert.assertEquals(ex, actual);
    }

    @Test
    public void testFruitValidation() {
        System.out.println("Test fruit is valid");
        List<Fruit> expect = new ArrayList<>();
        expect.add(apple);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.APPLE, LocalDate.of(2019, 1, 9));
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFruitValidation2() {
        System.out.println("Test fruit is valid 2");
        List<Fruit> expect = new ArrayList<>();
        expect.add(pear);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.PEAR, LocalDate.of(2019, 3, 20));
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFruitsOfFruitType() {
        System.out.println("Test fruit of fruit type");
        List<Fruit> expect = new ArrayList<>();
        expect.add(apple);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(FruitType.APPLE);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testFruitsOfFruitType2() {
        System.out.println("Test fruit of fruit type 2");
        List<Fruit> expect = new ArrayList<>();
        expect.add(orange);
        List<Fruit> actual = fruitShop.allFruitOfFruitType(FruitType.ORANGE);
        Assert.assertEquals(expect, actual);
    }
}