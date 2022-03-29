package pl.javastart.library.io.file;

import pl.javastart.library.model.Library;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class SerializableFileManager implements FileManager{

    private static final String FILE_NAME = "Library.o";

    @Override
    public Library importData() {

        return null;
    }

    @Override
    public void exportData(Library library) {

        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
