package rentCarPackage;

import rentCarPackage.Car;

class Truck extends Car {
    private double load;//最大装货量

    Truck(String name, int serialNumber, int rent, double load){//用构造函数初始
        super(name, serialNumber, rent);
        this.load = load;
    }

    public double getLoad() {
        return load;
    }

    public void showMessage(){//显示基本信息
        System.out.println("序号:"+getSerialNumber()+"\t车辆名称"+getName()+"\t租车费用(元/(车*天):"+getRent()+"\t最大载货(吨)"+load);
    }

    public double allLoad(){//所有出租的该类车的总的最大载货量
        return getLoad()*getRentNum();
    }

}
