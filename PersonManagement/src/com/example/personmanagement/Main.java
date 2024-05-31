package com.example.personmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("WELCOME TO PERSON MANAGEMENT !!");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		
		while(true) {
			System.out.println("Press 1 To ADD Person");
			System.out.println("Press 2 To DELETE Person");
			System.out.println("Press 3 To UPDATE Person");
			System.out.println("Press 4 To DISPLAY Person");
			System.out.println("Press 5 To EXIT");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1) {
				
				System.out.print("Name: ");
				String name = br.readLine();
				
				System.out.print("Phone: ");
				String phone = br.readLine();
				
				System.out.print("City: ");
				String city = br.readLine();
				
				Person pr = new Person(name, phone, city);
				
				boolean ans = PersonOp.insertPerson(pr);
				if(ans) {
					System.out.println("Student Successfully Added!!");
				}else {
					System.out.println("Student Added Failed!!");
				}
				
				
			}
			else if(c == 2) {
				
				System.out.println("Enter Person ID: ");
				int id = Integer.parseInt(br.readLine());
				
				boolean ans = PersonOp.deletePerson(id);
				
				if(ans) {
					System.out.println("Delete Person Successfully!!");
				}else {
					System.out.println("Sonething went wrong!!");
				}
				
			}
			else if (c == 3) {
				String state;
				String value;
				int id;
				
				System.out.print("Enter the ID: ");
				id = Integer.parseInt(br.readLine());
				System.out.print("Which field you wanna update: ");
				state = br.readLine();
				System.out.print("Enter the value: ");
				value = br.readLine();
				
				boolean ans = PersonOp.updatePerson(id, state, value);
				
				if(ans) {
					System.out.println("Person Details update successfully!!");
				}else {
					System.out.println("Failed!");
				}
				
			}
			else if(c == 4) {
				
				PersonOp.showPersons();
				
			}
			else if (c == 5) {
				break;
			}
			
		}

	}

}
