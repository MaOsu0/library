package pl.javastart.library.io.file;

import pl.javastart.library.exception.DataExportExeption;
import pl.javastart.library.exception.DataImportExeption;
import pl.javastart.library.model.Library;

import java.io.*;
import java.util.zip.DataFormatException;

class SerializableFileManager implements FileManager {

    private static final String FILE_NAME = "Library.o";

    @Override
    public Library importData() {
        try (
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportExeption("Nie znaleziono pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportExeption("Błąd wczytania danych z pliku " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportExeption("Niezgodny typ danych w pliku " + FILE_NAME);
        }


        return null;
    }

    @Override
    public void exportData(Library library) {

        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportExeption("Nie znaleziono pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportExeption("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }
}
