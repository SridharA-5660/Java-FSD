package camerarentalapp;
import java.util.*;

//camera class
class Camera{
	int camera_id;
	double rent_amnt;
	String brand,model;
	boolean available;
	public Camera(int id, double rent, String bnd, String mdl,boolean avl) {
		this.brand=bnd;
		this.camera_id=id;
		this.model=mdl;
		this.rent_amnt=rent;
		this.available=avl;
	}
	public int getCamera_id() {
		return camera_id;
	}
	public void setCamera_id(int camera_id) {
		this.camera_id = camera_id;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public double getRent_amnt() {
		return rent_amnt;
	}
	public void setRent_amnt(double rent_amnt) {
		this.rent_amnt = rent_amnt;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}

//Wallet class
class Wallet{
	double balance=1000;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}

//Main class
public class CameraRentalApplication {
	static Scanner sc=new Scanner(System.in);
	static List<Camera> lis_cam=new ArrayList<Camera>();
	Wallet wl=new Wallet();
	
	//method to add a camera
	public void add() {
		int camera_id;
		double rent_amnt;
		String brand,model;
		boolean available=true;
		sc.nextLine();
		System.out.println("Enter brand:");
		brand=sc.nextLine();
		
		System.out.println("Enter rent per day:");
		rent_amnt=sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter model:");
		model=sc.nextLine();
		if(!lis_cam.isEmpty()) {
		Camera cam=lis_cam.get(lis_cam.size()-1);
		
		camera_id=cam.camera_id+1;}
		else {
			camera_id=1;
		}
		lis_cam.add(new Camera(camera_id,rent_amnt,brand,model,available));
		System.out.println("Camera added succesfully to the list");		
	}
	
	//method to remove camera by camera id
	public void remove() {
		if(!lis_cam.isEmpty()) {
		int cmid;boolean flg=true;
		System.out.println("Enter the camera id to remove from list:");
		cmid=sc.nextInt();
		for(int i=0;i<lis_cam.size();i++) {
			Camera cam=lis_cam.get(i);
			if(cam.camera_id==cmid) {
				lis_cam.remove(i);
				System.out.println("Removed succesfully");
				flg=false;
			}
		}if(flg){System.out.println("Invalid id");}}
	}
	
	//method to display all cameras or  only available cameras
	public  void display(int d) {
		
		if(lis_cam.isEmpty()) {System.out.println("Currently there is no data presented");}
		else {
			System.out.println("--------------------------------------------");
			System.out.println("Cam_id   Brand\tModel   Rent pay  Available");
			System.out.println("--------------------------------------------");
		for(int i=0;i<lis_cam.size();i++) {
			Camera cam=lis_cam.get(i);
			String status=cam.isAvailable()?"Available":"Rented";
			
			if(d==1) {
				
			System.out.println(cam.camera_id+"\t"+cam.brand+"\t"+cam.model+"\t"+cam.rent_amnt+"\t"+status);}
			else {
				if(cam.isAvailable()) {
					System.out.println(cam.camera_id+"\t"+cam.brand+"\t"+cam.model+"\t"+cam.rent_amnt+"\t"+status);}
				}
			
			}System.out.println("--------------------------------------------");
			}
		
	}
	
	
	//method to add amount to wallet
	public void wl() {
		System.out.println("Current balance:"+wl.getBalance());
		int ch;
		double amnt;
		System.out.println("Add amount to your wallet(1.yes 2.no)");
		ch=sc.nextInt();
		if(ch==1) {
			System.out.println("\nEnter amount to add to your wallet:");
			amnt=sc.nextDouble();
			amnt+=wl.getBalance();
			wl.setBalance(amnt);
			System.out.println("Amount added succesfully\nCurrent balance:"+wl.getBalance());
		}
		
	}
	
	//method to rent a camera
	public void rent() {
		int cmid;boolean flg=true;
		if(!lis_cam.isEmpty()) {
		System.out.println("Enter camera  id to rent a camera:");
		cmid=sc.nextInt();
		for(int i=0;i<lis_cam.size();i++) {
		Camera cam=lis_cam.get(i);
		if(cam.camera_id==cmid) {
			flg=false;
			if(wl.getBalance()<cam.rent_amnt & cam.isAvailable()) {
				System.out.println("Error: Insufficient balance\nuse option 4 to add money to wallet");
			}else {
				if(cam.isAvailable()) {
				cam.setAvailable(false);
				double a=wl.getBalance()-cam.rent_amnt;
				wl.setBalance(a);
				System.out.println("camera is rented");
				System.out.println("Remaining balance:"+wl.getBalance());}
				else if(cam.isAvailable()==false) {
					System.out.println("Invalid id(It is currently rented)");
				}
			}
		}
		
		}if(flg) {
			System.out.println("Invalid id");
		}
		
		}
	}
	
	//main method
	public static void main(String[] args) {
		
		CameraRentalApplication cra=new CameraRentalApplication();
		
		lis_cam.add(new Camera(1,200,"canon","df01",true));
		lis_cam.add(new Camera(2,4500,"some","ad01",true));
		lis_cam.add(new Camera(3,2300,"sony","cv01",true));
		lis_cam.add(new Camera(4,560,"samsung","er01",false));
		lis_cam.add(new Camera(5,120,"leica","cv45",true));
		lis_cam.add(new Camera(6,3450,"nikon","as21",false));
		lis_cam.add(new Camera(7,120,"sony","cvm4",true));

		System.out.println("\t=====================================");
		System.out.println("\t  ***Camera Rental Application***\n\t\t\tby Sridhar A");
		System.out.println("\t=====================================");
		System.out.println("\n***Login page***");
		String user,pass;
		int choice,choice2,choice3;
		boolean flag=true,flag2;
		System.out.println("\nuser:");
		user=sc.nextLine();
		System.out.println("Password:");
		pass=sc.next();
		System.out.println("\nWelcome user:"+user+"\n");
		do {
		System.out.println("\n1.MY CAMERA\n2.RENT A CAMERA\n3.VIEW ALL CAMERA\n4.MY WALLET\n5.EXIT");
		System.out.println("Enter your choice: ");
		choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			do {
				flag2=true;
				System.out.println("\n1.ADD\n2.REMOVE\n3.VIEW MY CAMERA\n4.GO TO PREVIOUS MENU");
				System.out.println("Enter your choice:");
				choice2=sc.nextInt();
				switch(choice2) {
				case 1:cra.add();break;
				case 2:cra.display(1);cra.remove();break;
				case 3:cra.display(1);break;
				case 4:flag2=false;break;
				default:System.out.println("Invalid choice\n");
				}
			}while(flag2);
			break;
		case 2:cra.display(2);cra.rent();break;
		case 3:cra.display(1);break;
		case 4:cra.wl();break;
		case 5: flag=false;
				
				System.out.println("\n\t\t***Exiting the application***");
				break;
		default:System.out.println("Invalid choice\n");	
		
		break;	
		}
		}while(flag);
		
	}

}
