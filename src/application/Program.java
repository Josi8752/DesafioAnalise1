package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Sale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter with the file path: ");
		String path = sc.next();
		System.out.println();

		List<Sale> sales = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");

				int month = Integer.parseInt(fields[0]);
				int year = Integer.parseInt(fields[1]);
				String name = fields[2];
				int items = Integer.parseInt(fields[3]);
				double vendas = Double.parseDouble(fields[4]);

				sales.add(new Sale(month, year, name, items, vendas));

				line = br.readLine();
			}
			System.out.println("Frist five sales of 2016 of highest avarege mid price");
            System.out.println( );
		
          Comparator<Sale> comp =(s1, s2) -> s1.averagePrice().compareTo(s2.averagePrice());
            
			List<Sale> sale = sales.stream()

					.filter(x -> x.getYear().equals(2016))
					.sorted(comp.reversed())
					.limit(5)
					.collect(Collectors.toList());

			sale.forEach(System.out::println);
            
			System.out.println();
            System.out.println();
		    
            System.out.println("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = ");
		
           

			Double s = sales.stream()
					.filter(x -> x.getMonth().equals(1))
					.filter(x -> x.getMonth().equals(7))
					.filter(x -> x.getSeller().equals("logan"))
					
					.mapToDouble(x -> x.getTotal())
					.sum();
					
			System.out.println(s);
            
		}

		catch (

		IOException e) {
			System.out.println("Error: " + e.getMessage());

		}
		
		sc.close();
	}
}
