package collectionUtils;

import java.time.LocalDate;
import java.util.ArrayList;

import medical.app.core.KeyIngredient;
import medical.app.core.MedProduct;

public class ProductList {

	public static ArrayList<MedProduct> populateProduct(){
		ArrayList<MedProduct> productList=new ArrayList<>();
		productList.add(new MedProduct("Combiflam", KeyIngredient.valueOf("METHYLCOBALAMIN"),LocalDate.parse("2023-04-28"), 10,LocalDate.parse("2022-08-14") , LocalDate.parse("2022-07-16"), 39.00));
		productList.add(new MedProduct("Crocin", KeyIngredient.valueOf("ALPHA_LIPOIC_ACID"),LocalDate.parse("2023-08-06"), 14,LocalDate.parse("2023-04-11") , LocalDate.parse("2023-02-06"), 25.00));
		productList.add(new MedProduct("Sinarest", KeyIngredient.valueOf("INOSITOL"),LocalDate.parse("2023-05-11"), 4,LocalDate.parse("2023-01-19") , LocalDate.parse("2023-01-10"), 39.00));

		return productList;
				
				
	}
}
