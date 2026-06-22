import org.example.FileReader;
import org.example.FileService;
import org.example.FileWriter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FileServiceTest {
    @Test
    public void testServiceWithMockFileId(){
        FileReader mockFileReader=mock(FileReader.class);
        FileWriter mockFileWriter=mock(FileWriter.class);

        when(mockFileReader.read()).thenReturn("Mock File Content");

        FileService fileServic=new FileService(mockFileReader,mockFileWriter);
        String result=fileServic.processFile();

        assertEquals("Processed Mock File Content",result);

        verify(mockFileWriter).write("Processed Mock File Content");
    }
}
