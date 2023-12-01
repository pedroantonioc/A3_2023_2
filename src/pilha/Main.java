package pilha;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import util.Lista;



public class Main {
	public static void main(String[] args) throws FileNotFoundException {
        List<PilhaGrupo> grupos = new ArrayList<>();
        List<String> resultados = new ArrayList<>();
        
        

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\g2_as\\OneDrive\\Área de Trabalho\\Orçamentos Angélica\\entrada.txt"))) {
            String linha;
            
           
                       
                 
            
            boolean lista1Open = true;
            boolean lista2Open = false;
            boolean lista3Open = false;

            List<String> fila1 = new ArrayList<>();
            List<String> fila2 = new ArrayList<>();
            List<String> fila3 = new ArrayList<>();
            
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\s+");
                String comando = partes[0].toLowerCase();
                
                
                switch (comando) {
                    case "grupo:":
                        PilhaGrupo grupo = new PilhaGrupo();
                        for (int i = 1; i < partes.length; i++) {
                            grupo.adicionarPessoa(partes[i]);
                        }
                        grupos.add(grupo);
                        break;

                    case "existe:":
                        String pessoaABuscar = partes[1].toLowerCase();
                        boolean existe = false;
                        for (PilhaGrupo g : grupos) {
                            if (g.pessoaExiste(pessoaABuscar)) {
                                resultados.add("[" + pessoaABuscar + "] existe!");
                                existe = true;
                                break;
                            }
                        }
                        if (!existe) {
                            resultados.add("[" + pessoaABuscar + "] Não existe!");
                        }
                        break;

                    case "conhece:":
                        String pessoa1 = partes[1].toLowerCase();
                        String pessoa2 = partes[2].toLowerCase();
                        boolean encontrou = false;
                        for (PilhaGrupo g : grupos) {
                            if (g.pessoaExiste(pessoa1) && g.pessoaExiste(pessoa2)) {
                                resultados.add("[" + pessoa1 + "] conhece [" + pessoa2 + "]");
                                encontrou = true;
                                break;
                            }
                        }
                        if (!encontrou) {
                            resultados.add("[" + pessoa1 + "] Nao conhece [" + pessoa2 + "]");
                        }
                        break;
                        
                    case "criaroutrafila:":                    	
                    	
                    	if (lista1Open == true && lista2Open == false) {
                    		lista2Open = true;
        	        		resultados.add("Fila 2 aberta!");
        	        		break;
        	        	}else if(lista1Open == true && lista2Open == true) {
        	        		lista3Open = true; 
        	        		resultados.add("Fila 3 aberta!");
        	        		break;
        	        	}else {
        	        		resultados.add("numero de filas limite atingido");
        	        		break;
        	        	}
                    	
                    	
                    case "chegarpessoa:":
                    	
                    	
                    	
                    	String pessoaAChegar = partes[1].toLowerCase();
                    	
                        	
                    	
                    	resultados.add(pessoaAChegar + " chegou");
                    	
                    	if (lista1Open == true && lista2Open == true && lista3Open == false){
                    		
                    		
                    		for (int i = 0; i < grupos.size(); i++) {
                            	PilhaGrupo pegarGrupos = (PilhaGrupo) grupos.get(i);
                            	List <String> listaDePessoas = pegarGrupos.getGrupo(pessoaAChegar);
                            	
                            	                            	
                            	Iterator<String> it = listaDePessoas.iterator();
                            	
                            		System.out.println(listaDePessoas);
                            	
                            	
                            	
                            	
                            	if (listaDePessoas.contains(fila1)) {
                            		
                            		int index = listaDePessoas.indexOf(fila1);
                            		System.out.println(index + "o");
                            		fila1.add(index, pessoaAChegar);
                            		break;
                            		
                            	}else if(listaDePessoas.contains(fila2)) {
                            		
                            		int index = listaDePessoas.indexOf(fila2);
                            		System.out.println(index + "a");
                            		fila2.add(index, pessoaAChegar);
                            		break;
                            		
                            	}else if(listaDePessoas.contains(fila3)) {
                            		
                            		int index = listaDePessoas.indexOf(fila3);
                            		System.out.println(index);
                            		fila3.add(index, pessoaAChegar + "e");
                            		break;
                            		
                            	}else if (fila1.isEmpty() && fila2.isEmpty()) {
                    			
                            		fila1.add(pessoaAChegar);
                            		break;
                    			
                            	}else if(fila1.size() < fila2.size()){
                    			
                            		fila1.add(pessoaAChegar);
                            		break;
                    			
                            	}else if(fila1.size() > fila2.size()){
                    			
                            		fila2.add(pessoaAChegar);
                            		break;
                    			
                            	}else if(fila1.contains(pessoaAChegar)){
                            		
                            		resultados.add("pessoa já na fila");
                            		
                            		break;
                            		
                            	}else if(fila2.contains(pessoaAChegar)){
                            		
                            		resultados.add("pessoa já na fila");
                            		
                            		break;
                            		
                            	}else if(fila3.contains(pessoaAChegar)){
                            		
                            		resultados.add("pessoa já na fila");
                            		
                            		break;
                            		
                            	}else{
                            	
                            		fila1.add(pessoaAChegar);
                            		break;
                            		
                            	}
                    		}
                    		
                    		
                    	}else if(lista1Open == true && lista2Open == true && lista3Open == true) {
                    		
                    		for (int i = 0; i < grupos.size(); i++) {
                            	PilhaGrupo pegarGrupos = (PilhaGrupo) grupos.get(i);
                            	List <String> listaDePessoas = pegarGrupos.getGrupo(linha);
                            	
                            	
                            	
                            	if (listaDePessoas.contains(fila1)) {
                            		
                            		int index = listaDePessoas.indexOf(fila1);
                            		System.out.println(index);
                            		fila1.add(index, pessoaAChegar);
                            		break;
                            		
                            	}else if(listaDePessoas.contains(fila2)) {
                            		
                            		int index = listaDePessoas.indexOf(fila2);
                            		System.out.println(index);
                            		fila2.add(index, pessoaAChegar);
                            		break;
                            		
                            	}else if(listaDePessoas.contains(fila3)) {
                            		
                            		int index = listaDePessoas.indexOf(fila3);
                            		System.out.println(index);
                            		fila3.add(index, pessoaAChegar);
                            		break;
                            		
                            	}else if (fila1.isEmpty() && fila2.isEmpty() && fila3.isEmpty()) {
                    			
                    			fila1.add(pessoaAChegar);
                    			break;
                    			
                    		}else if (fila1.size() < fila2.size() && fila1.size() < fila3.size()) {
	                    		
	                    		fila1.add(pessoaAChegar);
	                    		break;
	                    		
	                        }else if(fila2.size() < fila1.size() && fila2.size() < fila3.size()) {
	                        	
	                        	fila2.add(pessoaAChegar);
	                        	break;
	                        	
	                        }else if(fila3.size() < fila1.size() && fila3.size() < fila2.size()) {
	                        	
	                        	fila3.add(pessoaAChegar);
	                        	break;
	                        	
	                        }else if(fila1.contains(pessoaAChegar)){
                        		
                        		resultados.add("pessoa já na fila");
                        		
                        		break;
                        		
                        	}else if(fila2.contains(pessoaAChegar)){
                        		
                        		resultados.add("pessoa já na fila");
                        		
                        		break;
                        		
                        	}else if(fila3.contains(pessoaAChegar)){
                        		
                        		resultados.add("pessoa já na fila");
                        		
                        		break;
                        		
                        	}else{
	                        	fila1.add(pessoaAChegar);
	                        	break;
	                        }
                    	}
                        	
                    }else {
                    	fila1.add(pessoaAChegar);
                    }
                     
                    case "imprimir:":
                    	resultados.add("Imprimir filas atuais");
                    	if (lista1Open == true && lista2Open == false && lista3Open == false) {
                    		
                    		resultados.add("Fila 1 " + fila1.toString());
                    	
                    	}else if(lista1Open == true && lista2Open == true && lista3Open == false) {
                    		
                    		resultados.add("Fila 1 " + fila1.toString());
                    		resultados.add("Fila 2 " + fila2.toString());
                    		
                    	}else if(lista1Open == true && lista2Open == true && lista3Open == true) {
                    	
                    		resultados.add("Fila 1 " + fila1.toString());
                    		resultados.add("Fila 2 " + fila2.toString());
                    		resultados.add("Fila 3 " + fila3.toString());
                    	
                    	}
                    	break;
                    	
                    case "desistirpessoa:":
                    	
                    	String pessoaADesistir = partes[1].toLowerCase();
                    	String filaremove = partes[2].toLowerCase();
                    	
                    	switch(filaremove) {
                    	case "fila1":
                    		fila1.remove(pessoaADesistir);
                    		break;
                    		
                    	case "fila2":
                    		fila2.remove(pessoaADesistir);
                    		break;
                    		
                    	case "fila3":
                    		fila3.remove(pessoaADesistir);
                    		break;
                    		
                    	default: 
                    		resultados.add("Pessoa ou fila não existe");
                    	
                    	}
                    	
                    	break;
                    	
                    case "atenderfila:":
                    	
                    	fila1.remove(0);
                    	fila2.remove(0);
                    	fila3.remove(0);
                    	
                    	break;
                    	
                    	
                    
                    	
                }
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar todos os resultados
        System.out.println("Resultados:");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
            
       
        
        } 
	
		
	
	}


	
	
