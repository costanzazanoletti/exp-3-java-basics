package learning.java.exercises.library;

public class Book {

  private String title; // not empty
  private int numPages; // > 0
  private String author; // not empty
  private String publisher; // not empty

  public Book(String title, int numPages, String author, String publisher)
      throws IllegalArgumentException {
    String exceptionMessage = "";
    if (isEmptyString(title)) {
      exceptionMessage += "title must not be empty,";
    }
    if (isEmptyString(author)) {
      exceptionMessage += "author must not be empty,";
    }
    if (isEmptyString(publisher)) {
      exceptionMessage += "publisher must not be empty,";
    }
    if (numPages <= 0) {
      exceptionMessage += "numPages must be greater than zero,";
    }
    if (exceptionMessage.length() > 0) {
      exceptionMessage = exceptionMessage.substring(0, exceptionMessage.length() - 1);
      throw new IllegalArgumentException(exceptionMessage);
    }
    this.title = title;
    this.numPages = numPages;
    this.author = author;
    this.publisher = publisher;
  }

  // GETTER e SETTER

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) throws IllegalArgumentException {
    if (isEmptyString(title)) {
      throw new IllegalArgumentException("Title must not be empty");
    }
    this.title = title;
  }

  public int getNumPages() {
    return numPages;
  }

  public void setNumPages(int numPages) throws IllegalArgumentException {
    if (numPages <= 0) {
      throw new IllegalArgumentException("numPages must be greater than zero");
    }
    this.numPages = numPages;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) throws IllegalArgumentException {
    if (isEmptyString(author)) {
      throw new IllegalArgumentException("Author must not be empty");
    }
    this.author = author;
  }

  public String getPublisher() {

    return publisher;
  }

  public void setPublisher(String publisher) throws IllegalArgumentException {
    if (isEmptyString(publisher)) {
      throw new IllegalArgumentException("Publisher must not be empty");
    }
    this.publisher = publisher;
  }

  // METODI
  private boolean isEmptyString(String s) {
    return s == null || s.trim().isEmpty();
  }

  @Override
  public String toString() {
    return "Book{" +
        "title='" + title + '\'' +
        ", numPages=" + numPages +
        ", author='" + author + '\'' +
        ", publisher='" + publisher + '\'' +
        '}';
  }
}
