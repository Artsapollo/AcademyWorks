package HW11;

import static HW11.FruitType.APPLE;
import static junit.framework.TestCase.assertEquals;

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

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FruitShopMockSpyTest {
    private List<Vitamins> vitamins = Arrays.asList(Vitamins.A);
    private Fruit apple = new Fruit(APPLE, 10, LocalDate.of(2019, 1, 1), 10, vitamins);
    @Spy
    @InjectMocks
    private FruitShop fruitShop;
    @Mock
    private Fruit appleMock;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
    }

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @Test
    public void mockTestAllFruitsOfFruitType() {
        when(appleMock.getFruitType()).thenReturn(FruitType.APPLE);
        FruitType expected = FruitType.APPLE;
        FruitType actual = appleMock.getFruitType();
        assertEquals(expected, actual);
    }

    @Test
    public void mockTestDaysToLive() {
        when(appleMock.getDayToLive()).thenReturn(10);
        int expected = 10;
        int actual = appleMock.getDayToLive();
        assertEquals(expected, actual);
    }

    @Test
    public void mockTestDeliveryDate() {
        when(appleMock.getDeliveryDate()).thenReturn(LocalDate.of(2019, 1, 9));
        LocalDate expected = LocalDate.of(2019, 1, 9);
        LocalDate actual = appleMock.getDeliveryDate();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyingAddingToFruitsList() {
        List fruits = Mockito.spy(new ArrayList());
        fruits.add(apple);
        verify(fruits).add(apple);
        assertEquals(1, fruits.size());
    }

    @Test
    public void stubbingFruitsSpyList() {
        List spyFruits = Mockito.spy(new ArrayList<>());
        spyFruits.add(apple);
        spyFruits.add(apple);
        spyFruits.add(apple);

        assertEquals(3, spyFruits.size());

        Mockito.doReturn(50).when(spyFruits).size();
        assertEquals(50, spyFruits.size());
    }
}