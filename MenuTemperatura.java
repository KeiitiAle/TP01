	 /*Dados já cadastrados no código são do mês de janeiro/2020 e seguem o seguinte formato:
	  10 primeiros dias com temperatura -10°C
	  10 seguintes dias com temperatura 15°C
	  11 restantes dias com 0° C
	  Somando todas as temperaturas: 50°C  
	  Média da temperatura: 50/31=1.61°C */


import java.util.Scanner; //leitura de dados

public class MenuTemperatura {
	public static void main(String[] args) {
		int mes;
		int ano;
		double[][][] data = new double [31][12][10];
		double temperatura;
		int id;
		int verificador=1;
		int diasCadastrados = 0;
		double mediaMes=0;
		double temperaturaDoMes=0;
		double maior=0;
		double menor =0;
		
		//Declarar temperaturas falsas para para cada posição no array para diferenciar o 0
		for (int i=0 ; i<31; i++) {
			for(int j=0; j<12; j++) {
				for (int k=0; k<10;k++) {
					data[i][j][k]=-300;
				}
			}
		
		}
		
		/*Dados de janeiro de 2020: 
		 10 primeiros dias com temperatura -10°C
		 10 seguintes dias com temperatura 15°C
		 11 restantes dias com 0° C
		 Somando todas as temperaturas: 50°C  
		Média da temperatura: 50/31=1.61°C */
		
		for(int i=0;i<10;i++) {
					data[i][0][9]=-10;
		}
			
		for(int i=10;i<=19;i++) {
			data[i][0][9]=15;
		}
		
		for(int i=20;i<31;i++) {
		data[i][0][9]=0;
		}
		
		
		Scanner ler = new Scanner(System.in);
		
		
		while (verificador==1) {
			/*Dizer ao usuário as suas opções*/
			System.out.print("Menu:\n\n");
			System.out.print("ID	Opção\n");
			System.out.print("1	Entrada das temperaturas\n");
			System.out.print("2	Cálculo da temperatura média\n");
			System.out.print("3	Cálculo da temperatura mínima\n");
			System.out.print("4	Cálculo da temperatura máxima\n");
			System.out.print("5	Relatório meteorológico\n\n");
			/*Pedir e coletar o ID que o usuário deseja*/
			System.out.print("Digite o ID da opção desejada:\n");
			
			id=ler.nextInt();
		switch(id) {
		
		case 1: 
			while(verificador == 1 ) {
			System.out.print("\nDigite o mês desejado (valores inteiros de 1 à 12)\n");
			mes=ler.nextInt();
			 if(mes >= 1 && mes <= 12) {
			System.out.print("\nDigite o ano (valores inteiros de 2011 à 2020)\n");
			ano=ler.nextInt();
		    
		    	 if(ano>=2011 && ano <= 2020) {
			         // Data Válida
			             if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10|| mes == 12) {
			                  
			                     for (int dia=1; dia<=31; dia++) {
			                    	System.out.print("\nDigite a temperatura em °C do dia  ");
			                    	System.out.println(dia + "/" + mes + "/" + ano + " (apenas valores a partir de -273):");
			                    	temperatura= ler.nextDouble();	
			                    	while (temperatura<-273) {
			                    	
			                    		System.out.print("\nTemperatura não permitida. \n");
			                    		System.out.print("\nDigite a temperatura em °C novamente do dia ");
				                    	System.out.println(dia + "/" + mes + "/" + ano + " (apenas valores a partir de -273):");
				                    	temperatura= ler.nextDouble();
			                    	
			                    	}
			                    	data[dia-1][mes-1][ano-2011]=temperatura;
			                    	
			                     }     
			                 
			             } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
		                     for (int dia=1; dia<=30; dia++) {
		                    	System.out.print("\nDigite a temperatura em °C do dia ");
		                    	System.out.println(dia + "/" + mes + "/" + ano + " (apenas valores a partir de -273):");
		                    	temperatura= ler.nextDouble();
		                    	data[dia-1][mes-1][ano-2011]=temperatura;
			                 }
			             } else if (mes == 2) {
			                 // Se o mês é fevereiro, é necessário saber se o ano é bissexto ou não, ou seja, se fevereiro tem 28 ou 29 dias.
			             	if ((ano%4==0 && ano%100!=0)||(ano%400==0)) {
			                     for (int dia=1; dia<=29; dia++) {
			                    	System.out.print("\nDigite a temperatura em °C do dia ");
			                    	System.out.println(dia + "/" + mes + "/" + ano + " (apenas valores a partir de -273):");
			                    	temperatura= ler.nextDouble();
			                    	data[dia-1][mes-1][ano-2011]=temperatura;
				                 }
			             	} else {
			                    for (int dia=1; dia<=28; dia++) {
			                    	System.out.print("\nDigite a temperatura em °C do dia ");
			                    	System.out.println(dia + "/" + mes + "/" + ano + " (apenas valores a partir de -273):");
			                    	temperatura= ler.nextDouble();
			                    	data[dia-1][mes-1][ano-2011]=temperatura;
				                 }
			             		}
			             	
			             }
			        
		    	 	} 
		    	 else {
		    		 System.out.println("\nAno inválido");
		    	 }
		    	 }
			  else {
		             // Mes invalido
		             System.out.println("\nMês inválido");
		          }
			 System.out.print("\nGostaria de cadastrar mais algum mês? Digite 1 para sim e 0 para não\n");
			verificador=ler.nextInt();
			 while (verificador!= 1 && verificador!= 0) {
				 
				System.out.print("Não ntendi.\n");
				System.out.print("Gostaria de cadastrar mais algum mês? Digite 1 para sim e 0 para não\n");
				verificador=ler.nextInt();
			 }
			}
					
		
		case 2:
			while(verificador == 1 ) {
			System.out.print("\nDigite o mês desejado (valores inteiros de 1 à 12)\n");
			mes=ler.nextInt();
			 if(mes >= 1 && mes <= 12) {
			System.out.print("\nDigite o ano (valores inteiros de 2011 à 2020)\n");
			ano=ler.nextInt();

	    	 if(ano>=2011 && ano <= 2020) {
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				diasCadastrados = diasCadastrados + 1;
	    			 temperaturaDoMes = temperaturaDoMes + data[dia-1][mes-1][ano-2011];
	    			 }


	    		 }
    		
    			 mediaMes = temperaturaDoMes/diasCadastrados;
    			 if (diasCadastrados>0) {
    				 
    				 System.out.printf("\nMédia da temperatura do mês " + mes + "/" + ano + ": %.2f°C.\n", mediaMes);
    			 }
    			 else {
    				 System.out.print("\nNão há nenhum cadastro para o mês escolhido.\n");
    				 
    				 
    			 }
			
			 }
	    	 else {
	    		 System.out.println("\nAno inválido");
	    	 }
	    	 }
		  else {
	             // Mes invalido
	             System.out.println("\nMês inválido");
	          }
				System.out.print("\nGostaria de selecionar outro mês? Digite 1 para sim e 0 para não.\n");
				verificador=ler.nextInt();
				diasCadastrados=0;
				temperaturaDoMes=0;
				mediaMes=0;
			}
			
		case 3: 
			while(verificador == 1 ) {
			System.out.print("\nDigite o mês desejado (valores inteiros de 1 à 12)\n");
			mes=ler.nextInt();
			 if(mes >= 1 && mes <= 12) {
			System.out.print("\nDigite o ano (valores inteiros de 2011 à 2020)\n");
			ano=ler.nextInt();

	    	 if(ano>=2011 && ano <= 2020) {
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				diasCadastrados = diasCadastrados + 1;
	    			 temperaturaDoMes = temperaturaDoMes + data[dia-1][mes-1][ano-2011];
	    			 mediaMes = temperaturaDoMes/diasCadastrados;
	    			    				 
	    			 }

	    		 }
	    		 //Cálculo da menor temperatura
	    		 menor = mediaMes;
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				 if(menor>data[dia-1][mes-1][ano-2011]) {
	    					 menor=data[dia-1][mes-1][ano-2011];
	    				 }

	    			    				 
	    			 }

	    		 }
	    		 //print do dia ou dias da menor temeperatura
	    		 System.out.print("\nO(s) dia(s) da menor temperatura do mês escolhido:\n" );
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				 
	    				 if(menor==data[dia-1][mes-1][ano-2011]) {
	    					System.out.print( dia + "/" + mes + "/" + ano + ".\n");
	    					
	    				 }

	    			    				 
	    			 }

	    		 }
	    		  
	    		 System.out.printf("Neste(s) dia(s) a temperatura média foi de: %.2f°C.\n", menor);
	    		 
    			 if (diasCadastrados==0) {		 
   				
    				 System.out.print("\nNão há nenhum cadastro para o mês escolhido.\n");
    				 
    			 }
			
			 }
	    	 else {
	    		 System.out.println("\nAno inválido");
	    	 }
	    	 }
		  else {
	             // Mes invalido
	             System.out.println("\nMês inválido");
	          }
				System.out.print("\nGostaria de selecionar outro mês? Digite 1 para sim e 0 para não.\n");
				verificador=ler.nextInt();
				diasCadastrados=0;
				temperaturaDoMes=0;
				mediaMes=0;
			}
			
		case 4: 
			while(verificador == 1 ) {
			System.out.print("\nDigite o mês desejado (valores inteiros de 1 à 12)\n");
			mes=ler.nextInt();
			 if(mes >= 1 && mes <= 12) {
			System.out.print("\nDigite o ano (valores inteiros de 2011 à 2020)\n");
			ano=ler.nextInt();

	    	 if(ano>=2011 && ano <= 2020) {
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				diasCadastrados = diasCadastrados + 1;
	    			 temperaturaDoMes = temperaturaDoMes + data[dia-1][mes-1][ano-2011];
	    			 mediaMes = temperaturaDoMes/diasCadastrados;
	    			    				 
	    			 }

	    		 }
	    		 maior = mediaMes;
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				 if(maior<data[dia-1][mes-1][ano-2011]) {
	    					 maior=data[dia-1][mes-1][ano-2011];
	    				 }

	    			    				 
	    			 }

	    		 }
	    		 System.out.print("\nO(s) dia(s) da maior temperatura do mês escolhido foi:\n");
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				 if(maior==data[dia-1][mes-1][ano-2011]) {
	    					System.out.print(dia + "/" + mes + "/" + ano + ".\n");
	    					
	    				 }

	    			    				 
	    			 }

	    		 }
	    		 System.out.printf("Neste(s) dia(s) a temperatura média foi de: %.2f°C.\n", maior);
    			 if (diasCadastrados==0) {		 
   				
    				 System.out.print("\nNão há nenhum cadastro para o mês escolhido.\n");
    				 
    			 }
			
			 }
	    	 else {
	    		 System.out.println("\nAno inválido");
	    	 }
	    	 }
		  else {
	             // Mes invalido
	             System.out.println("\nMês inválido");
	          }
				System.out.print("\nGostaria de selecionar outro mês? Digite 1 para sim e 0 para não.\n");
				verificador=ler.nextInt();
			}
			diasCadastrados=0;
			temperaturaDoMes=0;
			mediaMes=0;
			
		case 5:
			while(verificador == 1 ) {
			System.out.print("Digite o mês desejado (valores inteiros de 1 à 12)\n");
			mes=ler.nextInt();
			 if(mes >= 1 && mes <= 12) {
			System.out.print("Digite o ano (valores inteiros de 2011 à 2020)\n");
			ano=ler.nextInt();

	    	 if(ano>=2011 && ano <= 2020) {
//Cálculo da média
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				diasCadastrados = diasCadastrados + 1;
	    			 temperaturaDoMes = temperaturaDoMes + data[dia-1][mes-1][ano-2011];
	    			 
	    			    				 
	    			 }
	    			 mediaMes = temperaturaDoMes/diasCadastrados;
	    		 }
	    		 if (diasCadastrados>0) {
//Cálculo  da menor temperatura
	    		 menor = mediaMes;
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				 if(menor>data[dia-1][mes-1][ano-2011]) {
	    					 menor=data[dia-1][mes-1][ano-2011];
	    				 }

	    			    				 
	    			 }

	    		 }
	    		 
//Cálculo da maior temepratura
	    		 maior = mediaMes;
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				 if(maior<data[dia-1][mes-1][ano-2011]) {
	    					 maior=data[dia-1][mes-1][ano-2011];
	    				 }

	    			    				 
	    			 }

	    		 }
//Prints dos resultados
	    		 System.out.println("\nRelatório metereológico");
	    		 //print da temperatura de cada dia do mês
	    		 System.out.println("\n1.As médias de temperatura de cada um dos dias do mês desejado");
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				System.out.print("\nMédia da temperatura do dia " + dia + "/" + mes + "/" + ano +": "+ data[dia-1][mes-1][ano-2011]+ "°C.\n");
	    				 	    			    				 
	    			 }

	    		 }
	    		 //print da média da temperatura do mês

    				 System.out.printf("\n2. Média da temperatura do mês " + mes + "/" + ano + ": %.2f°C\n", mediaMes);
    		 
	    		 //print da menor temepratura do mês.
    				 System.out.print("\n3. Menor temperatura\n");
    				 System.out.print("\nO(s) dia(s) da menor temperatura do mês escolhido:\n" );
    	    		 for (int dia=1;dia<=31;dia++) {
    	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
    	    				 
    	    				 if(menor==data[dia-1][mes-1][ano-2011]) {
    	    					System.out.print( dia + "/" + mes + "/" + ano + ".\n");
    	    					
    	    				 }

    	    			    				 
    	    			 }

    	    		 }
    	    		 System.out.printf("Neste(s) dia(s) a temperatura média foi de: %.2f°C.\n", menor);
	    		 //print da maior temperatura
	    		 System.out.println("\n4. Maior temperatura");
	    		 System.out.print("\nO(s) dia(s) da maior temperatura do mês escolhido foi:\n");
	    		 for (int dia=1;dia<=31;dia++) {
	    			 if(data[dia-1][mes-1][ano-2011]!=-300) {
	    				 if(maior==data[dia-1][mes-1][ano-2011]) {
	    					System.out.print(dia + "/" + mes + "/" + ano + "\n");
	    					
	    				 }

	    			    				 
	    			 }

	    		 }
	    		 System.out.printf("Neste(s) dia(s) a temperatura média foi de: %.2f°C.\n", maior);
    			 }
	    		 else System.out.print("\nNão há nenhuma data cadastrada no mês desejado.\n");
			
			 }
	    	 else {
	    		 System.out.println("\nAno inválido\n");
	    	 }
	    	 }
		  else {
	             // Mes invalido
	             System.out.println("\nMês inválido\n");
	          }
				System.out.print("\nGostaria de selecionar outro mês? Digite 1 para sim e 0 para não.\n");
				verificador=ler.nextInt();
				diasCadastrados=0;
				temperaturaDoMes=0;
				mediaMes=0;
			}
			
		 System.out.print("Gostaria de selcionar outra opção? Digite 1 para sim e 0 para não.\n");
		verificador=ler.nextInt();
		 while (verificador!= 1 && verificador!= 0) {
			 
			System.out.print("Não ntendi.\n ");
			System.out.print("Gostaria de selecionar outra opção? Digite 1 para sim e 0 para não.\n");
			verificador=ler.nextInt();
			
			}
	}
		}
}

}
