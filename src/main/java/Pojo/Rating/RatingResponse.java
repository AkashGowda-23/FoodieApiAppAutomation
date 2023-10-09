package Pojo.Rating;

import Pojo.Restaurant;

public class RatingResponse {
	 private Long id;
	    private Double userRating;
	    private Restaurant restaurant;

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public Double getUserRating() {
	        return userRating;
	    }

	    public void setUserRating(Double userRating) {
	        this.userRating = userRating;
	    }

	    public Restaurant getRestaurant() {
	        return restaurant;
	    }

	    public void setRestaurant(Restaurant restaurant) {
	        this.restaurant = restaurant;
	    }
}
