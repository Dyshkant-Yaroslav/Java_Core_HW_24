package ua.lviv.desctop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Cinema {
	Scanner sc = new Scanner(System.in);
	TreeMap<Days, Shedule> schedules = new TreeMap<Days, Shedule>();
	ArrayList<Movie> moviesLibrary = new ArrayList<>();
	Time open;
	Time close;

	public Cinema(Time open, Time close) {
		super();
		this.open = open;
		this.close = close;
	}

	public void showMovies() {
		for (Movie movie : moviesLibrary) {
			System.out.println("Your movies library consist of: " + movie);
		}
	}

	public void addMovie() throws WrongTimeException {
		System.out.println("Enter name of movie to add it: ");
		String mov = sc.next().toUpperCase();
		System.out.println("Enter duration of movie minutes: ");
		int min = sc.nextInt();
		System.out.println("Enter duration of movie hours: ");
		int hour = sc.nextInt();
		moviesLibrary.add(new Movie(mov, new Time(hour, min)));
		showMovies();
	}

	public void addNewSeance() throws WrongTimeException {
		System.out.println("Enter day of seance: ");
		String day = sc.next();
		Days[] mas = Days.values();
		for (Days days : mas) {
			if (days.name().equalsIgnoreCase(day)) {
				schedules.put(days, addShedule());
			}
		}
		System.out.println(schedules);
	}

	public Shedule addShedule() throws WrongTimeException {
		Shedule sh = new Shedule();
		System.out.println("enter how much film you want add to seance: ");
		int count = sc.nextInt();
		for (int i = 0; i < count; i++) {
			sh.addSeance();
		}
		return sh;
	}

	public void removeMovie() {
		System.out.println("Enter name of film to remove it: ");
		String name = sc.next();
		Iterator<Movie> iterator = moviesLibrary.iterator();
		while (iterator.hasNext()) {
			Movie movie = (Movie) iterator.next();
			if (movie.getTitle().equalsIgnoreCase(name)) {
				iterator.remove();
			}

		}
		showMovies();
	}

	public void removeSeance() throws WrongTimeException {
		System.out.println("Enter day of seance: ");
		String day = sc.next();
		Days[] mas = Days.values();
		for (Days days : mas) {
			if (days.name().equalsIgnoreCase(day)) {
				Shedule.removeSeance();
			}
		}

		System.out.println(schedules);
	}

	public void showAllSeances() {
		System.out.println(schedules);
	}
}
