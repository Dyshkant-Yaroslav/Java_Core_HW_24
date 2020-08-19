package ua.lviv.desctop;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Shedule {

	 static Scanner sc= new Scanner(System.in);
	 static Set<Seance> seances = new TreeSet<>(new CustomComparator());
	
	public void  addSeance() throws WrongTimeException {
		System.out.println("Enter name of movie: ");
		String nameOfMovie = sc.next().toUpperCase();
		System.out.println("Enter filmDuration hours: ");
		int filmDurHour = sc.nextInt();
		System.out.println("Enter filmDuration minutes: ");
		int filmDurMin = sc.nextInt();
		System.out.println("Enter startTime hours: ");
		int startTimeHour = sc.nextInt();
		System.out.println("Enter startTime minutes: ");
		int startTimeMin = sc.nextInt();
	   seances.add(new Seance(new Movie(nameOfMovie, new Time(filmDurHour,filmDurMin)), new Time(startTimeHour, startTimeMin)));
	}
	public static  void removeSeance() {
		System.out.println("Enter the name of moovie to remove it: ");
		String name = sc.next().toUpperCase();
		Iterator<Seance> iterator = seances.iterator();
		while (iterator.hasNext()) {
			Seance next = (Seance) iterator.next();
			if(next.getMovie().getTitle().equalsIgnoreCase(name)) {
				iterator.remove();
			}
			
		}
	
	}

	@Override
	public String toString() {
		return "seances=" + seances ;
	}
	
}
