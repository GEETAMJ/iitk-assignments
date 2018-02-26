import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.SimpleDateFormat;  

abstract class Video{
	double play_duration;
	Date release_date;

	public Video(double x, Date date){
		this.play_duration = x;
		this.release_date = date;
	}

	public double GetPlayDuration(){
		return play_duration;
	}

	public void SetPlayDuration(double x){
		this.play_duration=x;
	}

	public abstract void SetReleaseDate(Date date);
	public abstract Date GetReleaseDate();
}

class Movie extends Video{
	String movie_name;
	public enum Rating {A,U,UA}
	Rating r;

	//implementing abstract methods of abstract class Video
	public void SetReleaseDate(Date date){
		release_date = date;
	}

	public Date GetReleaseDate(){
		return release_date;
	}

	//normal methods
	public Movie(double x, Date date,String name, Rating r){
		super(x,date);
		this.movie_name=name;
		this.r=r;
	}

	public String GetMovieName(){
		return movie_name;
	}

	public void SetMovieName(String name){
		this.movie_name=name;
	}

	public Rating GetRating(){
		return this.r;
	}

	public void SetRating(Rating r){
		this.r=r;
	}

	int Compare(Movie m1,Movie m2){
		if(m1.release_date.compareTo(m2.release_date)==0 && m1.movie_name.compareTo(m2.movie_name)==0){
			return 0;
		}
		else if(m1.movie_name.compareTo(m2.movie_name)>0){
			return 1;
		}
		else if(m1.movie_name.compareTo(m2.movie_name)<0){
			return -1;
		}
		
		else if(m1.release_date.compareTo(m2.release_date)>0){
			return 1;
		}
		else{
			return -1;
		}
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		Date d1=fmt.parse("21-02-2007");
		Date d2=fmt.parse("21-02-2000");
		String mvn1="Kal Ho Na Ho";
		String mvn2="Kal Ho Na Ho";
		double dur1 = 154.25;
		double dur2 = 200.01;
		Rating r1=Rating.UA;
		Rating r2=Rating.U;

		Movie m1= new Movie(dur1,d1,mvn1,r1);
		Movie m2= new Movie(dur2,d2,mvn2,r2);

		System.out.println(m1.GetRating());

		Integer res = m1.Compare(m1,m2);
		System.out.println(res);		
		if(res==0){
			System.out.println("Both Movies are equal");
		}
		else if(res>0){
			System.out.println("Movie 1 is greater than Movie 2");
		}
		else{
			System.out.println("Movie 1 is smaller than Movie 2");
		}
	}
}
