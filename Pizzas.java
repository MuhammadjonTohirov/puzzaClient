package pClient;

import java.awt.Image;
import java.io.File;

public class Pizzas 
{
	private String PizzaType;
	private float PizzaCost;
	private String defenition;
	private boolean isTicked;
	private byte[] image100;
	private byte[] image200;
	private int id;
	private int amount = 0;
	private float totalCost = 0;
	private static float total = 0;
	public Pizzas() {
		id = 0;
		PizzaType="PizzaType";
		PizzaCost=(float)0.0;
		isTicked = false;
	}
	
	public Pizzas(int id,String type,float cost,String definition,boolean isTicked,byte[] img100,byte[] img200) {
		setId(id);
		setPizzaType(type);
		setPizzaCost(cost);
		setTicked(isTicked);
		setDefenition(definition);
		setImage100(img100);
		setImage200(img200);	
		isTicked=false;
	}
	
	public float getPizzaCost() {
		return PizzaCost;
	}
	public void setPizzaCost(float pizzaCost) {
		PizzaCost = pizzaCost;
	}
	public String getPizzaType() {
		return PizzaType;
	}
	public void setPizzaType(String pizzaType) {
		PizzaType = pizzaType;
	}
	public String getDefenition() {
		return defenition;
	}
	public void setDefenition(String defenition) {
		this.defenition = defenition;
	}
	public boolean isTicked() {
		return isTicked;
	}
	public void setTicked(boolean isTicked) {
		this.isTicked = isTicked;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImage100() {
		return image100;
	}

	public void setImage100(byte[] image100) {
		this.image100 = image100;
	}

	public byte[] getImage200() {
		return image200;
	}

	public void setImage200(byte[] image200) {
		this.image200 = image200;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public static float getTotal() {
		return total;
	}

	public static void setTotal(float total) {
		Pizzas.total = total;
	}
}
