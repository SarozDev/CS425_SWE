package question2;


import edu.miu.question2.ArrayFlattenerService;
import edu.miu.question2.ArrayReversor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArrayReversorTest{
    @Mock
    private ArrayFlattenerService flattenerService;

    private ArrayReversor arrayReversor;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        arrayReversor = new ArrayReversor(flattenerService);
    }

    @Test
    public void testReverseArrayWithLegitInput(){
        int[][] inputArray = {{1,3},{0},{4,5,6}};
        int[] expectedOutput = {6,5,4,0,3,1};

        when(flattenerService.flattenArray(inputArray)).thenReturn(new int[]{1,3,0,4,5,6});
        int[] result = arrayReversor.reverseArray(inputArray);
        verify(flattenerService).flattenArray(inputArray);
        assertArrayEquals(expectedOutput,result);
    }

    @Test
    public void testReverseArrayWithNullInput(){
        int[][] inputArray = null;
//        when(flattenerService.flattenArray(any())).thenThrow(new AssertionError("Flattener service should not be called"));
//
//        int[] reversedArray = arrayReversor.reverseArray(inputArray);
//
//        verify(flattenerService, never()).flattenArray(any());
//        assertNull(reversedArray);

        when(flattenerService.flattenArray(inputArray)).thenReturn(null);
        int[] reversedArray = arrayReversor.reverseArray(inputArray);
        verify(flattenerService, times(1)).flattenArray(inputArray);

        assertNull(reversedArray);
    }
}
