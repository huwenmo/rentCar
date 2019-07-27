package rentCarPackage;

class PickupTruck extends Truck {//皮卡车继承Truck卡车类
    private int personNumber;//最大载人量
    PickupTruck(String name,int serialNumber,int rent,double load,int personNumber){//用构造函数初始
        super(name, serialNumber, rent,load);
        this.personNumber = personNumber;
    }
    public void showMessage(){//显示基本信息
        System.out.println("序号:"+getSerialNumber()+"\t车辆名称:"+getName()+"\t租车费用(元/(车*天):"+getRent()+"\t最大载人(人):"+personNumber+"\t最大载货(吨):"+getLoad());
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public int allPerson(){//所有出租的该类车的总的最大载量
        return getRentNum()*personNumber;
    }
}
