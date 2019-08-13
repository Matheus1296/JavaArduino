package serial;

public class Protocolo {

	private String valor_analogico;
	private String leituraComando;

	private void interpretaComando() {
		String aux[] = leituraComando.split(",");
		if (aux.length == 1) {
			valor_analogico = aux[0];
		}
	}

	public String getValor_analogico() {
		return valor_analogico;
	}

	public void setValor_analogico(String valor_analogico) {
		this.valor_analogico = valor_analogico;
	}

	public String getLeituraComando() {
		return leituraComando;
	}

	public void setLeituraComando(String leituraComando) {
		this.leituraComando = leituraComando;
		this.interpretaComando();
	}

}
