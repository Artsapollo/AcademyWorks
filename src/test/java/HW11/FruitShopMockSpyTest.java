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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FruitShopMockSpyTest {
    @Spy
    @InjectMocks
    private FruitShop fruitShop;
    @Mock
    private Fruit appleMock;
    @Mock
    private Fruit orangeMock;
    @Mock
    private Fruit pearMock;


    @Before
    public void before() {
        when(appleMock.getFruitType()).thenReturn(FruitType.APPLE);
        when(appleMock.getDayToLive()).thenReturn(30);
        when(appleMock.getDeliveryDate()).thenReturn(LocalDate.of(2019, 1, 10));
        when(appleMock.clone()).thenReturn(appleMock);

        when(orangeMock.getFruitType()).thenReturn(FruitType.ORANGE);
        when(orangeMock.getDayToLive()).thenReturn(20);
        when(orangeMock.getDeliveryDate()).thenReturn(LocalDate.of(2019, 1, 15));
        when(orangeMock.clone()).thenReturn(orangeMock);

        when(pearMock.getFruitType()).thenReturn(FruitType.PEAR);
        when(pearMock.getDayToLive()).thenReturn(10);
        when(pearMock.getDeliveryDate()).thenReturn(LocalDate.of(2019, 1, 20));
        when(pearMock.clone()).thenReturn(pearMock);

        doReturn(Arrays.asList(appleMock, orangeMock, pearMock)).when(fruitShop).getFruits();
    }


    @Test //returning null. WHY?
    public void testAllFresh() {
        List<Fruit> expected = Arrays.asList(appleMock);
        List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, 1, 15));
        assertEquals(expected, actual);
    }

    @Test
    public void testAllFruitsOfFruitType() {
        FruitType expected = FruitType.APPLE;
        FruitType actual = appleMock.getFruitType();
        assertEquals(expected, actual);
    }

    @Test
    public void testByExpireDate() {
        List<Fruit> expected = Arrays.asList(appleMock);
        List<Fruit> actual = fruitShop.checkByExpireDate(20);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testVerifyAllFresh() {
        fruitShop.allFresh(LocalDate.of(2019, 1, 24));
        verify(fruitShop, times(1)).getFruits();
        verify(appleMock, times(1)).getDayToLive();
        verify(orangeMock, times(1)).getDayToLive();
        verify(pearMock, times(1)).getDayToLive();
    }

    @Test //return NullPointerException
    public void testAllFreshAndFruitType() {
        List<Fruit> expected = Arrays.asList(pearMock);
        List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.PEAR, LocalDate.of(2019, 1, 25));
        assertEquals(expected, actual);
    }

    @Test
    public void testDeliveryDate() {
        when(appleMock.getDeliveryDate()).thenReturn(LocalDate.of(2019, 1, 9));
        LocalDate expected = LocalDate.of(2019, 1, 9);
        LocalDate actual = appleMock.getDeliveryDate();
        assertEquals(expected, actual);
    }

    @Test
    public void verifyAddingToFruitsList() {
        List fruits = Mockito.spy(new ArrayList());
        fruits.add(appleMock);
        verify(fruits).add(appleMock);
        assertEquals(1, fruits.size());
    }

    @Test
    public void stubAtFruitsSpyList() {
        List spyFruits = Mockito.spy(new ArrayList<>());
        spyFruits.add(appleMock);
        spyFruits.add(appleMock);
        spyFruits.add(appleMock);

        assertEquals(3, spyFruits.size());

        Mockito.doReturn(50).when(spyFruits).size();
        assertEquals(50, spyFruits.size());
    }

    @Test
    public void testAllFruitOfFruitTypeVerify() {
        fruitShop.allFruitOfFruitType(FruitType.PEAR);
        verify(fruitShop, times(1)).getFruits();
        verify(pearMock, times(1)).getFruitType();
    }

}
