package by.bsuir.kursovoi.chernyak.db.model;

public abstract class DBaseObjectAbsrt {
    private int id;
    
      public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DBaseObjectAbsrt{" + "id=" + id + '}';
    }
}
