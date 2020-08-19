package ua.lviv.desctop;

public class Time {

	private static int MINUTES_IN_HOUR = 60;
	private static int ZERO = 0;
	private static int HOURS_IN_DAY = 24;

	private int hour;
	private int min;

	public Time(int hour, int min) throws WrongTimeException {
		if (hour < ZERO || hour > HOURS_IN_DAY) {
			throw new WrongTimeException("You are out of hours range (0 - 24): " + hour);
		} else {
			this.hour = hour;
		}

		if (min < ZERO || min > MINUTES_IN_HOUR) {
			throw new WrongTimeException("You are out of minutes range (0 - 60): " + min);
		} else {
			this.min = min;
		}
	}

	public static Time calculateTime(Time startTime, Time endTime) throws WrongTimeException {
		int startTimeMinutes = convertTimeToMinutes(startTime);
		int endTimeMinutes = convertTimeToMinutes(endTime);
		int calculatedTimeMinutes = startTimeMinutes + endTimeMinutes;
		return new Time(calculateHoursFromMinutes(calculatedTimeMinutes), calculatedTimeMinutes % MINUTES_IN_HOUR);
	}

	private static int calculateHoursFromMinutes(int timeMinutes) {
		int hours = timeMinutes / MINUTES_IN_HOUR;
		if (hours > HOURS_IN_DAY) {
			return hours % HOURS_IN_DAY;
		}
		return hours;
	}

	private static int convertTimeToMinutes(Time time) {
		return time.getHour() * MINUTES_IN_HOUR + time.getMin();
	}

	public int getMin() {
		return min;
	}

	public int getHour() {
		return hour;
	}

	@Override
	public String toString() {
		return "hour:" + hour + " min:" + min;
	}

}
