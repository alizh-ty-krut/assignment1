public class Book {
    private int id;
    private static int idGen = 0;
    private String title;
    private String author;
    private int year;
    private boolean avaliable;

    public Book() {
        this.id = idGen++;
        this.avaliable = true;
    }

    public Book(String title, String author, int year) {
        this();

        setTitle(title);
        setAuthor(author);
        setYear(year);
    }

    public int getYear() {
        return this.year;
    }

    public int getId() {
        return this.id;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean getAvaliable() {
        return this.avaliable;
    }

    public String getTitle() {
        return this.title;
    }

    public void setYear(int year) {
        if (year >= 1500 && year <= 2025) {
            this.year = year;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        if ((author != null) && (!author.isEmpty())) {
            this.author = author;
        }
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public void setTitle(String title) {
        if ((title != null) && (!title.isEmpty())) {
            this.title = title;
        }
    }

    public void markAsBorrowed() {
        setAvaliable(false);
    }

    public void markAsReturned() {
        setAvaliable(true);
    }

    @Override
    public String toString() {
        return "ID = " + this.id + "\nTitle = " + this.title + "\nAuthor = " + this.author + "\nYear = " + this.year + "\nAvaliable status = " + this.avaliable + "\n";
    }
}
