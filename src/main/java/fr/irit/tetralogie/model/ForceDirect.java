package fr.irit.tetralogie.model;

import fr.irit.tetralogie.swing.Graphe;

public class ForceDirect {

	protected double energie = 0.0;
	Graphe gr;
	protected double K, L, D;
	public double minTemp = 3.0;
	public double temp = 5.0;

	public double time;

	public ForceDirect(Graphe gr, double d) {
		time = 0;
		this.D = d;
		this.L = d * gr.nombreSommets();
		this.K = Math.sqrt(this.L * this.L / gr.nombreSommets());
	}

	public double area() {
		return L * L;
	}

	public final double D() {
		return D;
	}

	public final void D(double d) {
		D = d;
	}

	public final double fa(double x, double ac, double ae) { /* ac*x*x/K; */
		/*
		 * System.out.println("valeur de fae :"+ae);
		 * System.out.println("valeur de fae :"+ac);
		 * System.out.println("resultat attraction : "+ (ac*Math.pow(x, ae)/K));
		 */return ac * Math.pow(x, ae) / K;
	}

	public final double fr(double x, double rc, double re) { /* rc* K*K/x; */
		/*
		 * System.out.println("valeur de fre :"+re);
		 * System.out.println("valeur de fre :"+rc);
		 * System.out.println("resultat repulsion : "+ (rc*(K*K)/Math.pow(x,
		 * re)));
		 */return rc * (K * K) / Math.pow(x, re);
	}

	public double K() {
		return Math.sqrt(area() / gr.nombreSommets());
	}

	public void K(double kk) {
		this.K = kk;
	}

	public final void L() {
		L = D * gr.nombreSommets();
	}

	public double max(double a, double b) {
		return (a > b) ? a : b;
	}

	public double min(double a, double b) {
		return (a < b) ? a : b;
	}

	public final double minTemp() {
		return minTemp;
	}

	public final void minTemp(double d) {
		minTemp = d;
	}

	// Temperature du systeme
	public final double temp(double t) {
		return (L / (2 * D)) / (1 + Math.exp(t / 8 - 5));
	}

	public final double Temp() {
		return temp;
	}

	public final void Temp(double d) {
		temp = d;
	}
} // class ForceDirect

