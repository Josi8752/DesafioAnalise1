package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.entities.Sale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Entre o caminho do arquivo: ");
		String path = sc.next();
		List<Sale> sales = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String salers = br.readLine();
			while (salers != null) {
				String[] fields = salers.split(",");
				sales.add(new Sale(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), (fields[2]),
						Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));
				salers = br.readLine();

			}
			System.out.println("Cinco primeiras vendas de 2016 de maior preço médio ");
		
			Comparator<Integer> comp = (s1, s2) -> s1.compareTo(s2);

			List<Integer> list = (List<Integer>) sales.stream()
					.map(x -> x.getYear())
					.filter(x -> x == 2016)
					.limit(5)
					.sorted(comp.reversed())
					.collect(Collectors.toList());
		list.forEach(System.out::println);
		}

		
		catch (

		IOException e) {
			System.out.println("Erro: " + e.getMessage());

		}
		System.out.println("terminou");
		sc.close();
	}
}
