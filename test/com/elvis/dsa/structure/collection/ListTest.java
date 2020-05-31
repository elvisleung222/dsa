package com.elvis.dsa.structure.collection;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ListTest {

    /**
     * Test add(), get(), remove() and size() methods
     */
    @Test
    void overallTest() {
        List<Integer> list = new ArrayList<>();

        // Keeping adding
        Assert.assertEquals(0, list.size());
        list.add(1);
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(Integer.valueOf(1), list.get(0));
        list.add(2);
        list.add(3);
        list.add(4);
        Assert.assertEquals(Integer.valueOf(4), list.get(3));
        list.add(5);
        list.add(6);
        Assert.assertEquals(6, list.size());
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        Assert.assertEquals(Integer.valueOf(12), list.get(11));
        list.add(13);
        list.add(14);
        Assert.assertEquals(14, list.size());

        // Remove consecutive elements
        Assert.assertEquals(Integer.valueOf(5), list.get(4));
        Assert.assertEquals(Integer.valueOf(6), list.get(5));
        Assert.assertEquals(Integer.valueOf(6), list.remove(6));
        Assert.assertEquals(Integer.valueOf(7), list.get(5));
        Assert.assertEquals(Integer.valueOf(7), list.remove(7));
        Assert.assertEquals(Integer.valueOf(8), list.get(5));

        // Final size
        Assert.assertEquals(12, list.size());
        // List element
        Assert.assertEquals(Integer.valueOf(14), list.get(11));


        // Find a non-existing element
        Assert.assertEquals(null, list.get(100));
        // Remove a non-existing element
        Assert.assertEquals(null, list.remove(100));


    }
}
