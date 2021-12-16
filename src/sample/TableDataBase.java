package sample;

public class TableDataBase {

    private int id;
    private String name;
    private int count;
    private String status;
    private String person;

    public TableDataBase(int id, String name, int count, String status, String person) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.status = status;
        this.person= person;
    }

    public TableDataBase() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int Count() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
