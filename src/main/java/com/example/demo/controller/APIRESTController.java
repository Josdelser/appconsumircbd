package com.example.demo.controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIRESTController {
	
	@GetMapping(path="/pacientes")
    @ResponseBody
    public  String listarPacientes() throws Exception{
        return peticionHttpGet("https://blooming-journey-23435.herokuapp.com/pacientes");
    }
	
	@GetMapping(path="/vacunas")
    @ResponseBody
    public  String listarVacunas() throws Exception{
        return peticionHttpGet("https://blooming-journey-23435.herokuapp.com/vacunas");
    }
	
	@GetMapping(path="/camas")
    @ResponseBody
    public  String listarCamas() throws Exception{
        return peticionHttpGet("https://blooming-journey-23435.herokuapp.com/camas");
    }
	
	@GetMapping(path="/pcrs")
    @ResponseBody
    public  String listarPcrs() throws Exception{
        return peticionHttpGet("https://blooming-journey-23435.herokuapp.com/pcr");
    }


    public static String peticionHttpGet(String urlParaVisitar) throws Exception {
          // Esto es lo que vamos a devolver
          StringBuilder resultado = new StringBuilder();
          // Crear un objeto de tipo URL
          URL url = new URL(urlParaVisitar);

          // Abrir la conexión e indicar que será de tipo GET
          HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
          conexion.setRequestMethod("GET");
          // Búferes para leer
          BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
          String linea;
          // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
          while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
          }
          // Cerrar el BufferedReader
          rd.close();
          // Regresar resultado, pero como cadena, no como StringBuilder
          return resultado.toString();
    }
}
