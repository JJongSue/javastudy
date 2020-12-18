package week5;

public class TV {
    boolean on;
    int channel;
    private int volume= 20;

    public TV() {
        print();
    }

    public TV(boolean on) {
        this(on, 0);
    }

    public TV(boolean on, int channel) {
        this.on = on;
        this.channel = channel;
        print();
    }

    public void turnOn(){
        on = true;
        System.out.println("TV On");
    }

    public void print(){
        System.out.println("TV " + on +" channel : " + channel + " volume : " + volume);
    }

    TV changeTv(){
        return this;
    }
}
