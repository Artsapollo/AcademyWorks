package lesson12;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StringChangerServiceNewTest {

    @Spy
    @InjectMocks
    private StringChangerService stringChangerService;

    @Mock
    private StringLowerUpperService stringLowerUpperService;

    @Test
    public void addStartUpperInputLowerTest() {
        when(stringLowerUpperService.toUpper(Mockito.anyString())).thenReturn("UPPER");
        when(stringLowerUpperService.toLower(Mockito.anyString())).thenReturn("lower");
        String expected = "UPPERlower";
        String actual = stringChangerService.addStartUpperInputLower("UpPeR", "LoWeR");
        assertEquals(expected, actual);
    }


    @Test
    public void testAddStartUpperInputLower() {
        when(stringLowerUpperService.toLower(Mockito.anyString())).thenReturn("lowervalue");
        when(stringLowerUpperService.toUpper("cat")).thenReturn("CAT");
        String expected = "CATlowervalue";
        String actual = stringChangerService.addStartUpperInputLower("cat", "input");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddStartAndEndTotalLower() {
        when(stringLowerUpperService.toLower(Mockito.anyString())).thenReturn("Start", "Input");
        String expected = "Start";
        String actual = stringChangerService.addStartAndEndTotalLower("Start", "End", "Input");
        Assert.assertEquals(expected, actual);
    }

//spy
    @Test
    public void addStartAndEndTest() {
        doReturn("startend").when(stringChangerService).addStart(Mockito.anyString(), Mockito.anyString());
        String expected = "startendmiddle";
        String actual = stringChangerService.addStartAndEnd("start", "middle", "end");
        assertEquals(expected, actual);
        verify(stringChangerService).addStart("start", "end");
    }


    @Test
    public void testAddStartUpperInputLowerSpy() {
        doReturn("lowervalue").when(stringLowerUpperService).toLower(Mockito.anyString());
        doReturn("CAT").when(stringLowerUpperService).toUpper(Mockito.anyString());
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
        doReturn("END").when(stringLowerUpperService).toUpper("end");
        String anctual = stringChangerService.addStartAndEndUpper("aaa", "end", "bbb");
        assertEquals(expected, anctual);
    }
}