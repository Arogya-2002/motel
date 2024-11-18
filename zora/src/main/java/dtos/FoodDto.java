package dtos;

public class FoodDto {

	private Long foodId;
    private String foodName;
    private Double price;
	public Long getFoodId() {
		return foodId;
	}
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public FoodDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodDto(Long foodId, String foodName, Double price) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
	}
    
}
