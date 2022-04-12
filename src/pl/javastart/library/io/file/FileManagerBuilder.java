package pl.javastart.library.io.file;

import pl.javastart.library.io.ConsolePrinter;
import pl.javastart.library.io.DataReader;
import pl.javastart.library.exception.NoSuchFileTypeExpection;

public class FileManagerBuilder {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerBuilder(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public FileManager build() {
        printer.printLine("Wybierz format danych: ");
        FileType fileType = getFileType();
        switch (fileType) {
            case SERIAL -> {
                return new SerializableFileManager();
            }
            case CSV -> {
                return new CsvFileManager();
            }
            default -> throw new NoSuchFileTypeExpection("Nieobsługiwany typ danych");
        }
    }

    private FileType getFileType() {
        boolean type0k = false;
        FileType result = null;
        do {
            printTypes();
            //serial, SERIAL
            String type = reader.getString().toUpperCase();
            try {
                result = FileType.valueOf(type);
                type0k = true;
            } catch (IllegalArgumentException e) {
                printer.printLine("Nieobsługiwany typ danych. Wybierz ponownie");
            }
        } while (!type0k);
        return result;
    }

    private void printTypes() {
        for (FileType value : FileType.values()) {
            printer.printLine(value.name());

        }
    }
}
