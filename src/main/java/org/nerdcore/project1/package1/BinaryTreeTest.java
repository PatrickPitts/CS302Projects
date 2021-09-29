package org.nerdcore.project1.package1;


import org.junit.*;
import org.junit.Assert.*;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    String[] base;
    @Before
    public void init(){
        base = new String['J'-'A'+1];
        for(int i = 'A'; i <='J'; i++){
            base[i-'A'] = Character.toString(i);
        }
    }

    @Test
    public void testVerify(){


    }
}
