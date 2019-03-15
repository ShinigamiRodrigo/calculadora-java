package calculos;

import java.lang.Math; 

public class FuncoesMatematicas {
	//Soma
	public double soma(double a, double b) {
		double total = a + b;
		return total;
	}
	
	//Subtração
	public double subtracao(double sub1, double sub2) {
		double totalSub = sub1 - sub2;
		return totalSub;
	}
	
	//Multiplicação
	public double multiplica(double mult1, double mult2) {
		double totalMult = mult1 * mult2;
		return totalMult;
	}
	
	//Divisão
	public double divisao(double div1, double div2) {
		double totalDiv = div1 / div2;
		return totalDiv;
	}
	
	//Porcentagem
	public double porcentagem(double porc1, double porc2) {
		double totalPorc = (porc1*porc2)/100;
		return totalPorc;
	}
	
	//Raiz Quadrada
		public double raiz(double raiz1) {
			double totalRaiz = Math.sqrt(raiz1);
			return totalRaiz;
		}
}
