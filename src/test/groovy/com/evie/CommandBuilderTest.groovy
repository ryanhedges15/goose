package com.evie
import com.evie.criteria.util.CommandBuilder
import org.junit.Ignore
import org.junit.Test

import static org.junit.Assert.assertEquals

/**
 * Created by rmhedge on 4/9/16.
 */
@Ignore
class CommandBuilderTest {


    @Test
    public void testCommandBuilderHappyDay() {
        String commandName = "ls";
        String arg1 = "-ltr";
        String arg2 = "-456"
        String[] command = CommandBuilder.build(commandName,arg1,arg2);
        assertEquals(3 , command.length)
        assertEquals(commandName, command[0]);
        assertEquals(arg1,command[1]);
        assertEquals(arg2,command[2]);

    }


}
