package lesson12;

import static junit.framework.TestCase.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StringChangerServiceUnitTest {
    @Spy
    @InjectMocks
    private StringChangerService stringChangerService;
    @Mock
    private StringLowerUpperService lowerUpperService;

    @Test
    public void testAddStartUpperInputLower() {
        when(lowerUpperService.toLower(Mockito.anyString())).thenReturn("lowervalue");
        when(lowerUpperService.toUpper("cat")).thenReturn("CAT");
        String expected = "CATlowervalue";
        String actual = stringChangerService.addStartUpperInputLower("cat", "input");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddStartAndEndTotalLower() {
        when(lowerUpperService.toLower(Mockito.anyString())).thenReturn("HoodTalks", "Input");
        String expected = "HoodTalks";
        String actual = stringChangerService.addStartAndEndTotalLower("HoodTalks", "End", "Input");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAddStartUpperInputLowerSpy() {
        doReturn("lowervalue").when(lowerUpperService).toLower(Mockito.anyString());
        doReturn("CAT").when(lowerUpperService).toUpper(Mockito.anyString());
        String expected = "CATlowervalue";
        String actual = stringChangerService.addStartUpperInputLower("cat", "input");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddStartAndEndSpy() {
        String expected = "aabbEnd";
        doReturn("aabb").when(stringChangerService).addStart("aa", "bb");
        String actual = stringChangerService.addStartAndEnd("aa", "End", "bb");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddStartAndEndUpperSpy() {
        String expected = "aaabbbEND";
        doReturn("aaabbb").when(stringChangerService).addStart("aaa", "bbb");
        doReturn("END").when(lowerUpperService).toUpper("end");
        String anctual = stringChangerService.addStartAndEndUpper("aaa", "end", "bbb");
        assertEquals(expected, anctual);
    }

    @Test
    public void testAddStartAndEndTotalLowerSpy() {
        stringChangerService.addStartAndEndTotalLower("aAa", "end", "bBb");
        verify(lowerUpperService).toLower(Mockito.anyString());
    }
}