
public class Simulate 
{
	public static void HWinterrupt()
	{
		if( Math.random() < 0.5 ) //Math.rando() è compreso tra 0 ---- 1
		{
			try
			{
				Thread.sleep(200); //aggiunge un ritardi di 200 millisecondi con una probabilità del 50%
			}
			catch (InterruptedException e) 
			{ }
		} //fine if
	} //fine metodo HWinterrupt

}//fine classe Simulate

/* Il metodo HWinterrupt della classe Simulate simula (tramite una chiamata al metodo statico 
 * sleep() della classe Thread) l'arrivo di un interrupt hardware che, nel 50% dei casi,
 * deschedula il thread corrente dalla CPU (forzando una sleep di 200 ms) */
