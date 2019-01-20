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
        System.out.println("Test");
        List<Fruit> expect = new ArrayList<>();
        expect.add(apple);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 1, 9));
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

}