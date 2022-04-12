package pl.javastart.library.io.file;

import com.sun.source.tree.TryTree;
import pl.javastart.library.exception.DataExportExeption;
import pl.javastart.library.exception.DataImportExeption;
import pl.javastart.library.exception.InvalidDataExeption;
import pl.javastart.library.model.Book;
import pl.javastart.library.model.Library;
import pl.javastart.library.model.Magazine;
import pl.javastart.library.model.Publication;

import java.io.*;
import java.util.Scanner;

class CsvFileManager implements FileManager {

    private static final String FILE_NAME = "Library.csv";

    @Override
    public Library importData() {
        Library library = new Library();
        try (
                var fileReader = new Scanner(new File(FILE_NAME));
                ){
            while (fileReader.hasNextInt()) {
                String line = fileReader.nextLine();
                Publication publication = createObjectFromString(line);
                library.addPublication(publication);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportExeption("Brak pliku " + FILE_NAME);
        }
        return library;
    }
    @Override
    public void exportData(Library library) {
        Publication[] publications = library.getPublications();
        try (
                var fileWriter = new FileWriter(FILE_NAME);
                var bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            for (Publication publication : publications) {
                bufferedWriter.write(publication.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportExeption("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }

    private Publication createObjectFromString(String csvText) {
        String[] split = csvText.split(";");
        String type = split[0];
        if (Book.TYPE.equals(type)) {
            return createBook(split);
        } else if (Magazine.TYPE.equals(type)) {
            return createMagazine(split);
        }
        throw new InvalidDataExeption("Nieznany typ publikacji " + type);
    }

    private Magazine createMagazine(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        String languange = data[4];
        int month = Integer.valueOf(data[5]);
        int day = Integer.valueOf(data[6]);
        return new Magazine(title, publisher, year, languange, month, day);
    }

    private Book createBook(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        int pages = Integer.valueOf(data[4]);
        String author = data[5];
        String isbn = data[6];
        return new Book(title, publisher, year, pages, author, isbn);
    }
}
