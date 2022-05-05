package cyborg.kami.geo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.filechooser.FileSystemView;

public class TestUtil {
    private static final String PATH = FileSystemView.getFileSystemView()
            .getDefaultDirectory()
            .getPath();
    private static final String NAME = PATH + "\\test.bin";

    public static <T extends Serializable> T io(T o)
            throws ClassNotFoundException, IOException {
        ObjectOutputStream objOutStream = new ObjectOutputStream(
                new FileOutputStream(NAME));
        objOutStream.writeObject(o);
        objOutStream.close();

        ObjectInputStream objInStream = new ObjectInputStream(
                new FileInputStream(NAME));

        @SuppressWarnings("unchecked")
        T read = (T) objInStream.readObject();

        objInStream.close();
        Files.deleteIfExists(Paths.get(NAME));
        return read;
    }
}