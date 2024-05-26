import org.example.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.util.List;

public class StorageTest {
    private Storage storage;
    private IDisk testDisk;

    @BeforeMethod
    public void init() {
        testDisk = new Music(Type.Music, "System of a down2",
                LocalDate.of(1992, 5, 5), 8);
        storage = new Storage();
        storage.add(testDisk);
    }

    @Test
    public void testGetByName() {
        IDisk actualDisk = storage.getBy("System of a down2");
        Assert.assertEquals(actualDisk, testDisk);
    }

    @Test
    public void testGetAllByType() {
        List<IDisk> actualDisks = storage.getAllBy(Type.Music);
        Assert.assertEquals(actualDisks, List.of(testDisk));
    }

    @Test
    public void testGetAllByRating() {
        List<IDisk> actualDisks = storage.getAllBy(5);
        Assert.assertEquals(actualDisks, List.of(testDisk));
    }

    @Test
    public void testisExistedByType() {
        Assert.assertTrue(storage.isExistedBy(Type.Music));
    }

    @Test
    public void testisExistedByNameNeg() {
        Assert.assertFalse(storage.isExistedBy("Wrong name"));
    }

    @Test
    public void testGetAllByYear() throws WrongParameterException {
        List<IDisk> actualDiscs = storage.getAllBy("1992");
        Assert.assertEquals(actualDiscs, List.of(testDisk));
    }

    @Test(expectedExceptions = WrongParameterException.class)
    public void testWrongParameterException() throws WrongParameterException {
        storage.getAllBy("3000");
    }
}
