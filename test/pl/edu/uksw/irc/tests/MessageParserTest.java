package pl.edu.uksw.irc.tests;

import junit.framework.Assert;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import pl.edu.uksw.irc.dto.Command;
import pl.edu.uksw.irc.dto.MessageDTO;
import pl.edu.uksw.irc.executor.MessageParser;
import pl.edu.uksw.irc.executor.MessageRenderer;

public class MessageParserTest {

    MessageParser parser;
    MessageRenderer renderer;
    
    @Before
    public void onSetUp(){
        parser = new MessageParser();
        renderer = new MessageRenderer();
    }
        
    /*@Test
    public void testPasswordMessage(){
        //parseMessage(":hello!sir@madam PRIVMSG #test :Hello, world!");
        String incomingMessage = ":hello!sir@madam PRIVMSG #test :Hello, world!";
        MessageDTO parseMessage = parser.parseMessage(incomingMessage);
        Assert.assertEquals(parseMessage.getName(), "hello");
        Assert.assertEquals(parseMessage.getUser(), "sir");
        Assert.assertEquals(parseMessage.getHost(), "madam");
        //Assert.assertEquals(parseMessage.getCommand(), "PRIVMSG");
        Assert.assertEquals(parseMessage.getMiddleParams(), "test ");
        Assert.assertEquals(parseMessage.getTrailingParams(), "Hello, world!");
        assertThat(parseMessage.getName(), not("h1ello"));
        
    }*/

    
     @Test
    public void testRendererMessage(){
        //parseMessage(":hello!sir@madam PRIVMSG #test :Hello, world!");
        
        
        String name = "";
        String user = "";
        String host = "";
        Command command = Command.NICK;
        String middleParams ="A";
        String trailingParams = "";
        //String msg2 = ":"+name+"!"+user+"@"+host+" "+command+" "+middleParams+" :"+trailingParams;
        
        
        MessageDTO message = new MessageDTO();
        
        message.setName(name);
        message.setUser(user);
        message.setHost(host);
        message.setCommand(command);
        message.setMiddleParams(middleParams);
        
        message.setTrailingParams(trailingParams);
        //String msg2 = ":hello!sir@madam PRIVMSG #test :Hello, world!";
        String msg2 = ":Angel PRIVMSG Wiz :Hello are you receiving this message?";
        String msg3 = ":"+name+" "+Command.PRIVMSG+" "+middleParams+ " :"+trailingParams;
        String msg = renderer.renderMessage(message);
        String msg4 = Command.NICK+ " "+middleParams;
        //Assert.assertEquals(msg, msg2);
        //Assert.assertEquals(msg, msg3);
        Assert.assertEquals(msg, msg4);
        
     
        
        
    }
    
    @Test
    public void testRendererMessageZPrefiksem(){       
        
        String name = "Angel";
        String user = "";
        String host = "";
        Command command = Command.PRIVMSG;
        String middleParams ="Wiz";
        String trailingParams = "Hello are you receiving this message?";
        
        MessageDTO message = new MessageDTO();
        
        message.setName(name);
        message.setUser(user);
        message.setHost(host);
        message.setCommand(command);
        message.setMiddleParams(middleParams);
        
        message.setTrailingParams(trailingParams);
        String msg3 = ":"+name+" "+Command.PRIVMSG+" "+middleParams+ " :"+trailingParams;
        String msg = renderer.renderMessage(message);
        Assert.assertEquals(msg, msg3);       
    }
}