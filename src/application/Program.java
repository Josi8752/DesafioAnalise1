package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Sale;


public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		List <Sale> sale = null ;
		
		System.out.print("Entre o caminho do arquivo: ");
		String path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			sale = new ArrayList<>();
			
			String salers = br.readLine();
			while (salers != null) {
			 String[] fields = salers.split(",");
				sale.add(new Sale (Integer.parseInt(fields[0]),Integer.parseInt(fields[1]),(fields[2]),Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));
			 salers = br.readLine();
			}
			
		}
		catch (IOException e){
		System.out.println("Erro: " + e.getMessage());
			
		}
	System.out.println(sale);
		sc.close();
	}

}
