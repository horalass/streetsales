package net.agilux;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "products")
public class Products {
	
	@DatabaseField(columnName = "id" ,generatedId = true)
	int id;
	@DatabaseField(columnName = "label", canBeNull=false )
	String label;
	@DatabaseField(columnName = "price", canBeNull=false )
	float price;
	
	public Products(){
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	
	public String toString(){
		return getLabel() +" "+getPrice();
	}
	
	


}
