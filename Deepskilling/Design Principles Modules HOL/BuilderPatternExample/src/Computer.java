public class Computer {
    private final String cpu;
    private final String storage;
    private final String ram;
    private final boolean wifi;

    private Computer(Builder builder){
        this.cpu=builder.cpu;
        this.ram=builder.ram;
        this.storage=builder.storage;
        this.wifi=builder.wifi;
    }

    @Override
    public String toString() {
        return "Computer: {" +
                "cpu='" + cpu + '\'' +
                ", storage='" + storage + '\'' +
                ", ram='" + ram + '\'' +
                ", wifi=" + wifi +
                '}';
    }

    public static class Builder{
        private String cpu;
        private String storage;
        private String ram;
        private boolean wifi;

        public Builder setCpu(String cpu){
            this.cpu=cpu;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }

}

