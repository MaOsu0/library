package pl.javastart.library.model;

public class Library {

    private final static int MAX_PUBLICATIONS = 2000;
    private int publicationNumber = 0;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];

    public void addBook(Book book) {
        if (publicationNumber < MAX_PUBLICATIONS) {
            publications[publicationNumber] = book;
            publicationNumber++;
        } else {
            System.out.println("Maksymalna liczba ksiażek została osiągnięta");
        }
    }


    public void printBooks() {
        int countBooks = 0;
        for (int i = 0; i < publicationNumber; i++) {
            if (publications[i] instanceof Book)
                System.out.println(publications[i].toString());
            countBooks++;
        }
        if (publicationNumber == 0) {
            System.out.println("Brak książek w bibliotece");
        }
    }


    public void addMagazine(Magazine magazine) {
        if (publicationNumber < MAX_PUBLICATIONS) {
            publications[publicationNumber] = magazine;
            publicationNumber++;
        } else {
            System.out.println("Maksymalna liczba magazynów została osiągnięta");
        }
    }

    public void printMagazines() {
        int countMagazines = 0;
        for (int i = 0; i < publicationNumber; i++) {
            if (publications[i] instanceof Magazine)
                System.out.println(publications[i].toString());
            countMagazines++;
        }
        if (publicationNumber == 0) {
            System.out.println("Brak magazynów w bibliotece");
        }

    }


}
