package comesting.example.codingstars.testwebserverpro.model;

public class model {
    private int id;
    private String name;
    private String shortdes;
    private double cgpa;
    private String mobilenum;
    private String image;
    public model(int id, String name, String shortdes, double cgpa, String mobilenum, String image) {
        this.id = id;
        this.name = name;
        this.shortdes = shortdes;
        this.cgpa = cgpa;
        this.mobilenum = mobilenum;
        this.image = image;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortdesc() {
        return shortdes;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getMobilenum() {
        return mobilenum;
    }

    public String getImage() {
        return image;
    }
}
