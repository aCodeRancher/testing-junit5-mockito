package guru.springframework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * Created by jt on 2018-10-29.
 */
@ExtendWith(MockitoExtension.class)
public class JUnitExtensionTest {

    @Mock
    Map<String, Object> mapMock;

    @Test
    void testMock() {

        mapMock.put("keyvalue", "foo");
        when(mapMock.size()).thenReturn(1);
        assertEquals(1, mapMock.size());
        Assertions.assertEquals(1, mapMock.size());
    }
}
