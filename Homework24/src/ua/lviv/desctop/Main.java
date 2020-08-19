package ua.lviv.desctop;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws WrongTimeException {
		Cinema c = new Cinema(new Time(9, 35), new Time(23, 40));
		Scanner sc = new Scanner(System.in);
		while (true) {
			menu();
			switch (sc.next()) {
			case "1": {
				c.addMovie();
			}
				break;
			case "2": {
				c.removeMovie();
				;
			}
				break;
			case "3": {
				c.showMovies();
				;
			}
				break;
			case "4": {
				c.addNewSeance();
			}
				break;
			case "5": {
				c.removeSeance();
			}
				break;
			case "6": {
				c.showAllSeances();
				;
			}
				break;
			}
		}

	}

	static void menu() {
		System.out.println("Press 1 to add new movie to library");
		System.out.println("Press 2 to remove movie from library");
		System.out.println("Press 3 to show movies library");
		System.out.println("Press 4 to add new seance");
		System.out.println("Press 5 to remove seance");
		System.out.println("Press 6 to show all seances");
	}
}
