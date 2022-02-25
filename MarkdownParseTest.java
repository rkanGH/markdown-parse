import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import org.junit.*;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void testParse() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("image.png","some-page.html"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void testParse1() throws IOException{
        Path fileName = Path.of("test2.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("image.url", "some-page.html"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void testParse2() throws IOException{
        Path fileName = Path.of("test3.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    

    @Test
    public void testSnippet1() throws IOException{
        Path fileName = Path.of("snippet1.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> list = new ArrayList<>();
        list.add("`google.com");
        list.add("google.com");
        list.add("ucsd.edu");
        assertEquals(list, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException{
        Path fileName = Path.of("snippet2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> list = new ArrayList<>();
        list.add("a.com");
        list.add("a.com(())");
        list.add("example.com");
        assertEquals(list, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException{
        Path fileName = Path.of("snippet3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> list = new ArrayList<>();
        list.add("https://ucsd-cse15l-w22.github.io/");
        assertEquals(list, MarkdownParse.getLinks(contents));
    }
}