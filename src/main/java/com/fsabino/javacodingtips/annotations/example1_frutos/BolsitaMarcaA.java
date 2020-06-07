package com.fsabino.javacodingtips.annotations.example1_frutos;

import com.fsabino.javacodingtips.annotations.annotation.Dulce;
import com.fsabino.javacodingtips.annotations.annotation.FrutoSeco;

public class BolsitaMarcaA {
	
	@FrutoSeco(calorias=500, tieneVitaminaE=true, arbolQueDaEsteFruto="Almendro")
	private int almendras = 50;
	
	@FrutoSeco(calorias=600, tieneVitaminaE=true, arbolQueDaEsteFruto="Avellano")
	private int avellanas = 40;
	
	@FrutoSeco(calorias=700, arbolQueDaEsteFruto="Pino")
	private int pinones = 30;
	
	@Dulce(2500)
	private int caramelos = 20;
	
	@Dulce(3800)
	private int chocolates = 15;
	
	private int juguetesPromocionales = 1;
}
