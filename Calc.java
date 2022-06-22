

// System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, "UTF-8"));

// <hr>
/* <b>class Calc</b>  
   A classe Calc será utilizada diretamente, não haverá um <u>objeto</u> calculadora, então
   o método "Main()", e os demais métodos da classe CALC, devem ser <u>static</u> 
*/   
// <pre>
class Calc
{
	static int Adicao( int p_Prim, int p_Seg )
	{
		return (p_Prim + p_Seg);
	}
	
	static int Subtracao( int p_Prim, int p_Seg )
	{
		return (p_Prim - p_Seg);
	}
	
	static void CaixaBranca()
	{
		// Variáveis:
			String Casos_de_Teste[][] = { 
										  {"Adicao", "27", "13", "40" }, 
										  {"Subtracao", "50", "60", "-10" },
										  {"Adicao", "123", "321", "444" },
										  {"Subtracao", "99", "9", "11" } 
										};
			int quant_teste = 0;
			int cont_teste = 0;
			String teste[] = { "", "", "", "" };
			String operacao = "";
			int prim_Oper = 0;
			int seg_Oper = 0;
			int esperado = 0;
			int calculado = 0;
			String resultado_teste = "";
			String mensagem = "";
		
		// Programa:
			quant_teste = Casos_de_Teste.length;
			for(cont_teste=0; cont_teste<quant_teste; cont_teste++)
			{
				// Executa o teste:
					operacao = Casos_de_Teste[cont_teste][0];
					prim_Oper = Integer.parseInt(Casos_de_Teste[cont_teste][1]);
					seg_Oper = Integer.parseInt(Casos_de_Teste[cont_teste][2]);
					esperado = Integer.parseInt(Casos_de_Teste[cont_teste][3]);
					
					switch(operacao)
					{
						case "Adicao": calculado = Adicao(prim_Oper, seg_Oper); 
									   break;
						case "Subtracao": calculado = Subtracao(prim_Oper, seg_Oper); 
										  break;
					}
					
				// Mostra o resultado do teste:
					resultado_teste = (calculado==esperado?"Ok":"Falhou");
					
					mensagem = operacao+": "+prim_Oper+" e "+seg_Oper+" = "+
							   calculado+"/"+esperado+" => "+resultado_teste;
					
					System.out.println(mensagem);
			}
	}
	
	public static void main(String[] p_Args)
	/*
		1. p_Args[0]: Operação
		2. p_Args[1]: Primeiro operando
		3. p_Args[2]: Segundo operando
	*/
	{
		// Variáveis:
			String operacao = "";
			int prim_Oper = 0;
			int seg_Oper = 0;
			int resultado = 0;
		
		// Programa:		
			operacao = p_Args[0];
			if ( operacao.equals("CaixaBranca") )
			{
				CaixaBranca();
			}
			else
			{
				prim_Oper = Integer.parseInt(p_Args[1]);
				seg_Oper = Integer.parseInt(p_Args[2]);
				
				switch(operacao)
				{
					case "Adicao": resultado = Adicao(prim_Oper, seg_Oper); break;
					case "Subtracao": resultado = Subtracao(prim_Oper, seg_Oper); break;
				}
				
				System.out.println(resultado);
			}
	}
}