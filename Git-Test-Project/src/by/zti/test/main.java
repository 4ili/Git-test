package by.zti.test;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class main {
	private static ArrayList<Profile> profiles = new ArrayList<Profile>();

	public static void main(String[] args) {
		System.out.println(profiles.size());
		Profile profile = new Profile();
		profile.setName(JOptionPane.showInputDialog(null, "¬ведите ваше им€"));
		profile.setSurname(JOptionPane.showInputDialog(null, "¬ведите вашу фамилию"));
		profiles.add(profile);
		for (Profile p : profiles){
			System.out.println(p.getName()+" "+p.getSurname());
		}
		System.out.println(profiles.size());
	}	
}

