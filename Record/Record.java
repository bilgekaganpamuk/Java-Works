package chap_02.Record;

public class Record {
    private int key;

    public Record() {
        key = 0;
    }

    public Record(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return String.format("Key: %3d\n", getKey());
    }

    public void print() {
        System.out.println(this.getClass().getName() + this.toString());
    }
}
