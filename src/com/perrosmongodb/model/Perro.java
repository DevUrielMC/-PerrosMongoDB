package com.perrosmongodb.model;

public class Perro {
	private String nombre;
	private int edad;
	private float peso;
	private String color;
	private boolean estaVivo;
	private String raza;
	
	
	
	public Perro(String nombre, int edad, float peso, String color, boolean estaVivo, String raza) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.color = color;
		this.estaVivo = estaVivo;
		this.raza = raza;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isEstaVivo() {
		return estaVivo;
	}
	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
}
