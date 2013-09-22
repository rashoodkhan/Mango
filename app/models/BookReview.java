package models;

import java.util.Map;

public class BookReview {
	
	//Average rating of the book
	double avgRating;
	
	//Maps uid -> review
	Map<String,Review> reviews;
	
	//Total number of reviews
	int totalCount;
}
