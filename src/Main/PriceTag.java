package Main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class PriceTag {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> prod = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char cha = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (cha == 'c') {

				prod.add(new Product(name, price));

			} else if (cha == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				prod.add(new UsedProduct(name, price, date));
			} else {
				System.out.print("Customs fee: ");
				double custom = sc.nextDouble();
				prod.add(new ImportedProduct(name, price, custom));

			}

		}
		System.out.println();

		System.out.println("PRICE TAGS:");
		for (Product pr : prod) {
			System.out.println(pr.priceTag());
		}

		sc.close();

	}

}
