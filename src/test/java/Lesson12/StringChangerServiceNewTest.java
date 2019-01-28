package Lesson12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
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
    public void addStartAndEndUpperTest() {
        when(stringLowerUpperService.toUpper(Mockito.anyString())).thenReturn("END");
        String expected = "startmiddleEND";
        String actual = stringChangerService.addStartAndEndUpper("start", "end", "middle");
        assertEquals(expected, actual);
    }


    @Test
    public void addStartUpperInputLowerReverse() {
        when(stringLowerUpperService.toLower(Mockito.anyString())).thenReturn("UPPER");
        when(stringLowerUpperService.toUpper(Mockito.anyString())).thenReturn("lower");
        String expected = "lowerUPPER";
        String actual = stringChangerService.addStartUpperInputLower("UpPeR", "LoWeR");
        assertEquals(expected, actual);
    }


    @Test
    public void addStartAndEndTest() {
        doReturn("startend").when(stringChangerService).addStart(Mockito.anyString(), Mockito.anyString());
        String expected = "startendmiddle";
        String actual = stringChangerService.addStartAndEnd("start", "middle", "end");
        assertEquals(expected, actual);
        verify(stringChangerService).addStart("start", "end");
    }


    @Test
    public void addStartAndEndUpperTestSpy() {
        doReturn("startinput").when(stringChangerService).addStart(Mockito.anyString(), Mockito.anyString());
        when(stringLowerUpperService.toUpper("end")).thenReturn("END");
        String expected = "startinputEND";
        String actual = stringChangerService.addStartAndEndUpper("start", "end", "upper");
        assertEquals(expected, actual);
        verify(stringLowerUpperService).toUpper("end");
    }

    @Test
    public void addStartAndEndTotalLowerTest() {
        doReturn(stringChangerService.addStart("start", "input") + "end").when(stringLowerUpperService).toLower(Mockito.anyString());
        String expected = "startinputend";
        String actual = stringChangerService.addStartAndEndTotalLower("start", "end", "input");
        assertEquals(expected, actual);
        verify(stringLowerUpperService).toLower("startinputend");
    }

}