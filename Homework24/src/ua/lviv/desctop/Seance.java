package ua.lviv.desctop;

public class Seance {

	private Movie movie;
	private Time startTime;
	private Time endTime;
	public Seance(Movie movie, Time startTime) throws WrongTimeException {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = Time.calculateTime(startTime, movie.getDuration());
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return  movie + ", startTime=" + startTime + ", endTime=" + endTime ;
	}
	
	
	
	
	
}
