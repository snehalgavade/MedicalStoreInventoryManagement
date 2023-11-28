package medicalTester;
import static collectionUtils.ProductList.populateProduct;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import customException.SameNameFoundException;
import medical.app.core.KeyIngredient;
import medical.app.core.MedProduct;

public class MedTester {

	public static void main(String[] args) {
		ArrayList<MedProduct> finalProductList=populateProduct();
		System.out.println(finalProductList);
		try(Scanner sc=new Scanner(System.in)){
			
			boolean exit=true;
			while(exit) {
				System.out.println("Please select an option from following menu\n");
				System.out.println("1.Add new medical product\n");
				System.out.println("2.Update Stock od a product\n");
				System.out.println("3.Remove all expired product\n");
				System.out.println("4.List out products which are never sold in 9 months after added to store\n");
				System.out.println("5.Display all products");
				System.out.println("6.Exit");
				
		
				switch(sc.nextInt()) {
				case 1:
					//add new 
					System.out.println("Please enter name of the product you want add");
					String nameOfProdFromUser=sc.next();
					MedProduct nameObj=new MedProduct(nameOfProdFromUser);
					int index = finalProductList.indexOf(nameObj);
					if (index == -1) {
						System.out.println("NOT FOUND");
						System.out.println("Enter Key Ingredient");
						String keyIngredient1=sc.next().toUpperCase();
						System.out.println("Enter Expiry date in(yyyy-mm-dd) only");
						String expiryDate1=sc.next();
						System.out.println("Enter Stock to be entered");
						int stockFromUser=sc.nextInt();
						System.out.println("Enter Date you want this product to be listed on");
						String listingDate1=sc.next();
						System.out.println("Enter price of the product");
						double priceOfProduct=sc.nextDouble();
						
						finalProductList.add(new MedProduct(nameOfProdFromUser,KeyIngredient.valueOf(keyIngredient1),LocalDate.parse(expiryDate1),stockFromUser,LocalDate.now(),LocalDate.parse(listingDate1),priceOfProduct));
						
						System.out.println("Product added succesfully");
					} else {
						System.out.println("Same name found");
						throw new SameNameFoundException("Product with same name already exits please update the stock if required");
					}
						
					break;
				case 2://update stock
					System.out.println("Please enter id of the product whose stock you want to update");
					int idOfProdFromUser=sc.nextInt();
					MedProduct idObj=new MedProduct(idOfProdFromUser);
					boolean flag=false;
					for(MedProduct mp1:finalProductList)
					{
						if(mp1.getId()==idObj.getId()) {
						System.out.println("Please enter stock of the product you want to update");
						int stockOfProdFromUser=sc.nextInt();
						mp1.setStock(stockOfProdFromUser);
						System.out.println("StockUpdate suyccesfull");
						flag=true;
						System.out.println(mp1);
						}
						
					}
					 if(!flag)
						System.out.println("Invalid id");
					break;
					
				case 3://remove expired
					try {
					for(MedProduct mp2:finalProductList) {
						if(mp2.getExpiry().isBefore(LocalDate.now())) {
							finalProductList.remove(mp2);
							System.out.println(mp2);
							System.out.println("Product removed succesfully");
						}
					}
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
					break;
				case 4://display pro not sold in 9 months
					long monthsToSubtract=(long) 9;
					for(MedProduct mp3: finalProductList) {
						if(mp3.getStockUpdateDate().isBefore(LocalDate.now().minusMonths(monthsToSubtract))) {
							System.out.println(mp3);
						}
						
					}
			
					break;
				case 5://display all
					System.out.println(finalProductList);
					break;
			case 6://exit

					try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("MedicalProdList.ser"))) {
						os.writeObject(finalProductList);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					exit=false;
					break;
				}//end of switch	
			}//end of while
		}//end of try
		catch(SameNameFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}//end of catch
	}//end of main()
}//end of class
