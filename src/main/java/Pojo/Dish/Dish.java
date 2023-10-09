package Pojo.Dish;

import java.util.Set;

public class Dish {
	
	   private Long id;
	    private String name;
	    private String category;
	    private double price;
	    private String description;
	    private String image;
	    private Set<String> availableDays;
		public Set<String> getAvailableDays() {
			return availableDays;
		}
		public void setAvailableDays(Set<String> availableDays) {
			this.availableDays = availableDays;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}

}
