abstract class Publication {
    private int Id;
    private String title;
    private double price;
    private String author;

    public Publication(int Id, String title, double price, String author) {
        this.Id = Id;
        this.title = title;
        this.price = price;
        this.author = author;
    }
    public int getId() {
        return Id;
    }
    public String getTitle() {
        return title;
    }
    public double getPrice() {
        return price;
    }
    public String getAuthor() {
        return author;
    }
    
}