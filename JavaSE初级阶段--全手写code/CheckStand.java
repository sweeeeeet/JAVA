import java.util.Scanner;

public class CheckStand{
public static void main(String[] args){
	
	menu();
}
public static void menu(){
	System.out.println("*************** 欢迎使简易收银台 *****************");
	System.out.println("       [U] 使用 [S] 设置 [A] 关于 [Q] 退出        ");
	System.out.println("             输入:  U S A Q 进入操作              ");
	System.out.println("**************************************************");
	PayMent pay=new PayMent();
	Insert set=new Insert();
		Scanner scan = new Scanner(System.in);
		String input=scan.nextLine();
		if(input.equals("u")||input.equals("U")){
			//买单功能
			
			pay.menu();
		}
		if(input.equals("s")||input.equals("S")){
			//设置功能
			
			set.menu();
		}
		if(input.equals("a")||input.equals("A")){
			//展示软件信息
			about();
			menu();
		}
		if(input.equals("q")||input.equals("Q")){
			//退出功能
			quit();
		}
		
	}
	
	public static void about(){
	System.out.println("-------------------- 关于 -----------------------");
	System.out.println("        名称：简易收银台                         ");
	System.out.println("        功能：基于字符界面的收银台操作系统       ");
	System.out.println("        作者: sweeeeeet                          ");
	System.out.println("        版本: v0.0.1                             ");
	System.out.println("        意见反馈：自行消化，不接受反驳           ");
	System.out.println("-------------------------------------------------");
	
	}
	public static void quit(){
	System.out.println("-------------------- 退出 -----------------------");
	System.out.println("                欢迎使用，下次再见               ");
	System.out.println("-------------------------------------------------");
	}
}

class PayMent{
	private static double sum=0.0;
public void menu(){

	System.out.println("-------------------- 买单功能 -------------------");
	System.out.println("         [S] 浏览 [A] 下单 [L] 支付 [Q] 退出     ");
	System.out.println("            输入:  S A D L Q 进入操作            ");
	System.out.println("-------------------------------------------------");
	PayMent pay=new PayMent();
    Insert set=new Insert();
	Scanner scan = new Scanner(System.in);
	String input=scan.nextLine();
		if(input.equals("s")||input.equals("S")){
			//查看商品清单
			set.showGoods();
			pay.menu();
		}
		if(input.equals("a")||input.equals("A")){
			//下单功能			
			pay.shop();
			pay.menu();
		}
		if(input.equals("l")||input.equals("L")){
			//支付
			pay.pay();
			pay.menu();
		}
		if(input.equals("q")||input.equals("Q")){
			//退出功能
			CheckStand.menu();
		}

}

public void shop(){
	PayMent pay=new PayMent();
    Insert set=new Insert();
	while(true){
	System.out.println("请输入要购买的商品信息（如下格式：1 ）,选择完毕请输0:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	
	if(num>0&&num<11){
		if(set.getProductName(num-1)!=null||!(" -- [未上架]".equals(set.getProductName(num-1)))){
			sum+=set.getPrice(num-1);
	   System.out.println("您本次购物总额为"+sum);
		}else{
	   System.out.println("此货架暂无商品");
	   break;
		}
	}
	else{
		break;
	}
}
}

public void pay(){
		System.out.println("请付款，输入金额");
	Scanner scan = new Scanner(System.in);
	double num =scan.nextDouble();
	System.out.println("给您找零"+(num-sum)+"元");

}

}

class Insert{
private static int[] goodsNum=new int[]{1,2,3,4,5,6,7,8,9,10};
private static String[] productName=new String[10];
private static double[] productPrice=new double[10];
public double getPrice(int num){
	return productPrice[num];
}
public String getProductName(int num){
	return productName[num];
}
public void menu(){
	System.out.println("------------------- 设置功能 --------------------");
	System.out.println("    [S] 查看 [A] 上架 [D] 下架 [U] 修改 [Q] 退出 ");
	System.out.println("       输入:  S  A  D  U  Q  进入操作            ");
	System.out.println("-------------------------------------------------");
	PayMent pay=new PayMent();
    Insert set=new Insert();
	Scanner scan = new Scanner(System.in);
	String input=scan.nextLine();
		if(input.equals("s")||input.equals("S")){
			//查看商品清单
			set.showGoods();
			set.menu();
		}
		if(input.equals("u")||input.equals("U")){
			//修改功能
			set.modification();
			set.menu();
		}
		if(input.equals("d")||input.equals("D")){
			//下架功能
			set.remove();
			set.menu();
		}
		if(input.equals("a")||input.equals("A")){
			//上架录入信息
			set.putaway();
			set.menu();
		}
		if(input.equals("q")||input.equals("Q")){
			//退出功能
			set.quit();
		}
		
}
public void showGoods(){	
		PayMent pay=new PayMent();
		Insert set=new Insert();
	System.out.println("------------------  商品清单  -------------------");
	System.out.println("        编号    产品名称                单价     ");
	for(int i=0;i<10;i++){
		if(i==9){
		if(productName[i]==null){
			productName[i]="-- [未上架]";
System.out.println("      "+goodsNum[i]+"    "+productName[i]+"                "+productPrice[i]);
		}
		else{
System.out.println("      "+goodsNum[i]+"    "+productName[i]+"                "+productPrice[i]);
		}
		}
		else{
		if(productName[i]==null){
			productName[i]="-- [未上架]";
System.out.println("       "+goodsNum[i]+"    "+productName[i]+"                "+productPrice[i]);
		}
		else{
System.out.println("       "+goodsNum[i]+"    "+productName[i]+"                "+productPrice[i]);
		}
		}
	
	}
	System.out.println("-------------------------------------------------");
}

public void putaway(){
	PayMent pay=new PayMent();
    Insert set=new Insert();
	System.out.println("请输入上架商品信息（如下格式：1 餐巾纸 1.4）:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	String name=scan.next();
	double price=scan.nextDouble();
	for(int i=0;i<10;i++){
		if(num==goodsNum[i]){
		if(productPrice[i]==0.0){			
			productName[i]=name;
			productPrice[i]=price;	
			break;			
		    
			}
			else{
			System.out.println("此编号已有货物录入，请为当前货物编录新编号");
			set.putaway();
		}
		}
		
	}
	set.showGoods();
	}
	public void modification(){
		PayMent pay=new PayMent();
    Insert set=new Insert();
	System.out.println("请输入修改商品信息（如下格式：1 餐巾纸 1.4）:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	String name=scan.next();
	double price=scan.nextDouble();
	for(int i=0;i<10;i++){
		
		if(num==goodsNum[i]){
			productName[i]=name;
			productPrice[i]=price;
			set.showGoods();
			}
			
		}
		
	}	
	
	public void remove(){
		PayMent pay=new PayMent();
    Insert set=new Insert();
	System.out.println("请输入下架商品编号（如下格式：1）:");
	Scanner scan = new Scanner(System.in);
	int num =scan.nextInt();
	for(int i=0;i<10;i++){
		
		if(num==goodsNum[i]){
			productName[i]=null;
			productPrice[i]=0.0;
			set.showGoods();
			}
			
		}	
	}
	
	public void quit(){
		CheckStand.menu();
	}
}

