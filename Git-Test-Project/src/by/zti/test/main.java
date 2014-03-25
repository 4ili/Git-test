package by.zti.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class main {
	private static ArrayList<Profile> profiles = new ArrayList<Profile>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		profiles = (ArrayList<Profile>) dserData("profiles");
		System.out.println(profiles.size());
		Profile profile = new Profile();
		profile.setName(JOptionPane.showInputDialog(null, "Введите ваше имя"));
		profile.setSurname(JOptionPane.showInputDialog(null, "Введите вашу фамилию"));
		profiles.add(profile);
		for (Profile p : profiles){
			System.out.println(p.getName()+" "+p.getSurname());
		}
		System.out.println(profiles.size());
		serData("profiles", profiles);
	}

	private static Object dserData(String file_name) {
		Object retObject = null;
		
		try {
			FileInputStream fileIn = new FileInputStream(file_name+".ser");
			try {
				ObjectInputStream in = new ObjectInputStream(fileIn);
				try {
					retObject = in.readObject();
				} catch (ClassNotFoundException e) {
					System.out.println("Клас не найден");
					System.exit(3);
				}
				fileIn.close();
				in.close();
			} catch (IOException e) {
				System.out.println("Ошибка ввода/вывода");
				System.exit(2);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден");
			System.exit(1);
		}
		return retObject;
	}

	private static void serData(String file_name, Object obj) {
		try {
			FileOutputStream fileOut = new FileOutputStream(file_name+".ser");
			try {
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(obj);
				fileOut.close();
				out.close();
			} catch (IOException e) {
				System.out.println("Ошибка ввода/вывода");
				System.exit(2);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Файл не найден");
			System.exit(1);
		}
		
	}	
}

