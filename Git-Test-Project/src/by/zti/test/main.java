package by.zti.test;
import java.util.ArrayList;
import by.zti.SerializationManager;
import javax.swing.JOptionPane;

public class main {
	private static ArrayList<Profile> profiles = new ArrayList<Profile>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		profiles = (ArrayList<Profile>) SerializationManager.deSerializeData("profiles", "ser", "");
		System.out.println(profiles.size());
		Profile profile = new Profile();
		profile.setName(JOptionPane.showInputDialog(null, "������� ���� ���"));
		profile.setSurname(JOptionPane.showInputDialog(null, "������� ���� �������"));
		profiles.add(profile);
		for (Profile p : profiles){
			System.out.println(p.getName()+" "+p.getSurname());
		}
		System.out.println(profiles.size());
		SerializationManager.serializeData(profiles, "profiles", "ser", "");
	}
	
}

