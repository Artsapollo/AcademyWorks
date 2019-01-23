package Lesson12;

import static junit.framework.TestCase.assertEquals;

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
//        when(lowerUpperService.toLower(Mockito.anyString())).thenReturn("lowervalue");
//        when(lowerUpperService.toUpper("cat")).thenReturn("CAT");
        doReturn("lowervalue").when(lowerUpperService).toLower(Mockito.anyString());
        doReturn("CAT").when(lowerUpperService).toUpper(Mockito.anyString());
        String expected = "CATlowervalue";
        String actueal = stringChangerService.addStartUpperInputLower("cat", "input");
        assertEquals(expected, actueal);
    }

    @Test
    public void testAddStartAndEnd() {
        String expected = "aabbEnd";
        doReturn("aabb").when(stringChangerService).addStart("aa", "bb");
        String actual = stringChangerService.addStartAndEnd("aa", "End", "bb");
        assertEquals(expected, actual);
    }

    @Test
    public void testAddStartAndEndUpper() {
        String expected = "aaabbbEND";
        doReturn("aaabbb").when(stringChangerService).addStart("aaa", "bbb");
        doReturn("END").when(lowerUpperService).toUpper("end");
        String anctual = stringChangerService.addStartAndEndUpper("aaa", "end", "bbb");
        assertEquals(expected, anctual);
    }

    //    @Test
//    public void testAddStartAndEndTotalLower(){
//        doReturn("aAaCHANGEDbBbCHANGED").when(stringChangerService).addStart("aAa", "bBb");
//        String actual = stringChangerService.addStartAndEndTotalLower("aAa", "end", "bBb");
//        verify(lowerUpperService).toLower("aAaCHANGEDbBbCHANGEDend");
//
//    }
//
//        @Test
//    public void testAddStartAndEndTotalLower(){
//        String actual = stringChangerService.addStartAndEndTotalLower("aAa", "end", "bBb");
//        verify(lowerUpperService).toLower("aAabBbend");
//
//    }
    @Test
    public void testAddStartAndEndTotalLower() {
        String actual = stringChangerService.addStartAndEndTotalLower("aAa", "end", "bBb");
        verify(lowerUpperService).toLower(Mockito.anyString());
    }
}