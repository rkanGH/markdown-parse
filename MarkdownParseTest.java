import static org.junit.Assert.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import org.junit.*;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void testParse() throws IOException{
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }
    @Test
    public void testParse1() throws IOException{
        Path fileName = Path.of("test2.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(""), MarkdownParse.getLinks(contents));
    }
    @Test
    public void testParse2() throws IOException{
        Path fileName = Path.of("test3.md");
	    String contents = Files.readString(fileName);
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
}