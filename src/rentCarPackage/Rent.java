package rentCarPackage;

import java.util.Scanner;

public class Rent {
    private Scanner sc = new Scanner(System.in);//接收键盘输入
    private LoadBus NO1 = new LoadBus("小轿车",1,40,4);
    private LoadBus NO2 = new LoadBus("面包车",2,65,7);
    private LoadBus NO3 = new LoadBus("大巴车",3,180,20);
    private Truck NO4 = new Truck("低栏车",4,30,1.5);
    private Truck NO5 = new Truck("高栏车",5,47,2.5);
    private Truck NO6 = new Truck("厢式车",6,80,4.5);
    private PickupTruck NO7 = new PickupTruck("日式皮卡车",7,60,1,5);
    private PickupTruck NO8 = new PickupTruck("美式皮卡车",8,60,2,3);
    private Car[] cars = {NO1,NO2,NO3,NO4,NO5,NO6,NO7,NO8};
    private final int store = 8;//车的种类为8恒定
    public void start(){
        ClearDisplay();
        display();
        selectCar();
        displaySelect();
        endRent();
    }
    private void display(){//显示所有车
        System.out.println("**********租车系统***********");
        System.out.println("以下是所有车型:");
        System.out.println("载客车:");
        NO1.showMessage();
        NO2.showMessage();
        NO3.showMessage();
        System.out.println("载货车:");
        NO4.showMessage();
        NO5.showMessage();
        NO6.showMessage();
        System.out.println("皮卡车:");
        NO7.showMessage();
        NO8.showMessage();
    }
    private void selectCar(){//选车
        System.out.println("**********开始选车*********");
        int day=0,num=0;
        for(int i=0;i<store;i++){
            System.out.println("请输入序号"+cars[i].getSerialNumber()+"("+cars[i].getName()+")的租用量为(辆):");
            while((num=sc.nextInt())<0)
            {
                System.out.println("请输入正确的数字");
                sc.nextLine();
            }
            cars[i].setRentNum(num);
            if(num >0){//只有当要租的车的数量大于0时才开始继续输入要租的时间。
                System.out.println("请输入序号"+cars[i].getSerialNumber()+"("+cars[i].getName()+")的租用时间为(天):");
                while((day=sc.nextInt())<=0)
                {//要租车，已经选了车了，时间不能为0
                    System.out.println("请输入正确的数字");
                    sc.nextLine();
                }
                 cars[i].setRentDay(day);
            }
        }
    }
    private void displaySelect(){//选车结果计数和显示
       // 总体租车的最大载人（货）量，总体租车费用，租车天数，，各个车辆的租用数目（分行列出，数目为0不用列出）
        int allPerson = NO1.allPerson()+NO2.allPerson()+NO3.allPerson()+NO7.allPerson()+NO8.allPerson();
        //总体租车的最大载人量
        double allLoad = NO4.allLoad()+NO5.allLoad()+NO6.allLoad()+NO7.allLoad()+NO8.allLoad();
        //总体租车的最大载货量
        int allMoney =0;
        //总的租金
        //int allDay = 0;//总的租的天数
        int allCarNum = 0;//总的租车的数量。
        for(int i=0;i<store;i++){
            //allDay += cars[i].getRentDay();
            allMoney += cars[i].rentMoney();
            allCarNum += cars[i].getRentNum();
        }
        if(allCarNum<=0){
            System.out.println("你是什么都没有选。");
        }
        else{
            if(allPerson>0){
                System.out.println("总体租车的最大载人量:"+allPerson);
            }
            if(allLoad!=0){
                System.out.println("总体租车的最大载货量:"+allLoad);
            }
            if(allMoney>0){
                System.out.println("总体租车费用:"+allMoney);
            }
            if(allCarNum>0){
                System.out.println("租用车辆总数:"+allCarNum);
            }
        }
        for(int i=0;i<store;i++){
            if(cars[i].rentMoney()>0)
            {
                System.out.println(cars[i].getName()+"有"+cars[i].getRentNum()+"辆出租"+cars[i].getRentDay()+"天");
            }
        }
    }
    private void endRent(){//结束
        System.out.println("是否确认选择，重选输入‘#’，确认按任意其他键加回车");
        if(sc.next().equals("#")){//判断输入是否为"#",为则重新选车
            start();
        }
        else{
            System.exit(0);
        }
    }
    private static void ClearDisplay(){
        //清屏
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public static void main(String[] args) {
        new Rent().start();
    }
}
