package rentCarPackage;

abstract class Car{
    private String name;//汽车名字
    private int serialNumber;//汽车编号
    private int rent;//每辆车每天的租金
    private int rentDay;//出租的天数
    private int rentNum;//出租的数量
    Car(String name, int serialNumber, int rent){//构造函数来初始化
        this.name = name;
        this.serialNumber = serialNumber;
        this.rent = rent;
        this.rentNum =0;
        this.rentDay =0;
    }

    public int getRentNum() {
        return rentNum;
    }

    public void setRentNum(int rentNum) {
        this.rentNum = rentNum;
    }

    public String getName() {
        return name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getRent() {
        return rent;
    }

    public void setRentDay(int rentDay) {
            this.rentDay = rentDay;
    }

    public int getRentDay() {
        return rentDay;
    }

    public int rentMoney(){//计数出该种车的出租的总租金
        return rentDay*rentNum*rent;
    }

    abstract void showMessage();//抽象一个显示信息方法
}



