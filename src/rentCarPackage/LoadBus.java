package rentCarPackage;

import rentCarPackage.Car;

class LoadBus extends Car {//载客车，继承Car父类
    int personNumber;//所能载客的数量

    public int getPersonNumber() {
        return personNumber;
    }

    LoadBus(String name, int serialNumber, int rent, int personNUmber){//用构造函数初始
        super(name, serialNumber, rent);
        this.personNumber = personNUmber;
    }
    public void showMessage(){//显示基本信息
        System.out.println("序号:"+getSerialNumber()+"\t车辆名称:"+getName()+"\t租车费用(元/(车*天):"+getRent()+"\t最大载人数(人):"+personNumber);
    }
    public int allPerson(){//该类车所出租的车的总的最大载人量
        return getRentNum()*getPersonNumber();
    }
}
