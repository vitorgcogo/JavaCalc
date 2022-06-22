import java.io.*;

class CaixaPreta
{

	public static void main(String[] p_Args)
	{
		// Variáveis:
			ProcessBuilder java_Calc = null;
			InputStreamReader resp_Calc = null;
			BufferedReader saida_Calc = null;			
			
			String Casos_de_Teste[][] = { 
										  {"Adicao", "60", "12", "72" }, 
										  {"Adicao", "14", "26", "40" },
										  {"Subtracao", "70", "12", "58" },
										  {"Subtracao", "14", "26", "-12" } 
										};
			int quant_teste = 0;
			int cont_teste = 0;
			String teste[] = { "", "", "", "" };
			String operacao = "";
			String prim_Oper = "";
			String seg_Oper = "";
			int esperado = 0;
			int calculado = 0;
			String resultado_teste = "";
			String mensagem = "";
			
		// Programa:
		try
		{
			quant_teste = Casos_de_Teste.length;
			for(cont_teste=0; cont_teste<quant_teste; cont_teste++)
			{
				// Cria o processo para o aplicativo:
					operacao = Casos_de_Teste[cont_teste][0];
					prim_Oper = Casos_de_Teste[cont_teste][1];
					seg_Oper = Casos_de_Teste[cont_teste][2];
					esperado = Integer.parseInt(Casos_de_Teste[cont_teste][3]);
					java_Calc = new ProcessBuilder( "java.exe", "Calc", 
													operacao, prim_Oper, seg_Oper );
					java_Calc.redirectErrorStream(true);

					Process exec_Calc = java_Calc.start();  

				// Captura a saída da calculadora
					resp_Calc = new InputStreamReader(exec_Calc.getInputStream());
					saida_Calc = new BufferedReader(resp_Calc);
					calculado = Integer.parseInt(saida_Calc.readLine());
					
				// Mostra o resultado do teste:
					resultado_teste = (calculado==esperado?"Ok":"Falhou");
					
					mensagem = operacao+": "+prim_Oper+" e "+seg_Oper+" = "+
							   calculado+"/"+esperado+" => "+resultado_teste;
					
					System.out.println(mensagem);
				
				// Finaliza:
					exec_Calc.waitFor();			
					saida_Calc.close();
			}
			
			System.exit(0);
		}
		catch(Exception erro)
		{
			System.out.println("Erro ao executar o comando pelo DOS.");
		}
	}
}