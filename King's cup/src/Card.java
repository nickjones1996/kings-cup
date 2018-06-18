
public class Card {
private int value;
private String name;
private String imageSource;
private String category;
public Card()
{}
public Card(int value, String name, String category)
{
	this.value = value;
	this.name = name;
	this.category = category;
	imageSource = "images"  + "\\" + name.replace(' ', '_')+".png";
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getImageSource() {
	return imageSource;
}
public void setImageSource(String imageSource) {
	this.imageSource = imageSource;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
}
