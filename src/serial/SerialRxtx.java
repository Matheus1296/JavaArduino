package serial;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import view.TelaUsuario;

public class SerialRxtx implements SerialPortEventListener {

    private TelaUsuario telaUsuario = null;

    SerialPort serialPort = null;

    private Protocolo protocolo = new Protocolo();
    private String appName;

    private BufferedReader input;
    private OutputStream output;

    private static final int TIME_OUT = 1000;
    private static final int DATA_RATE = 9600;

    private String serialPortName = "COM4";

    public boolean iniciaSerial(TelaUsuario telaUsuario) {

        this.telaUsuario = telaUsuario;
        boolean status = false;

        try {
            CommPortIdentifier portId = null;
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

            while (portId == null && portEnum.hasMoreElements()) {
                CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

                if (currPortId.getName().equals(serialPortName) || currPortId.getName().startsWith(serialPortName)) {
                    serialPort = (SerialPort) currPortId.open(appName, TIME_OUT);
                    portId = currPortId;
                    System.out.println("Connectado em :" + currPortId.getName());
                    break;
                }
            }

            if (portId == null || serialPort == null) {
                return false;
            }

            serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

            status = true;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    public void sendData(String data) {
        try {
            output = serialPort.getOutputStream();
            output.write(data.getBytes());
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    @Override
    public void serialEvent(SerialPortEvent spe) {// Entrada de dados do arduino
        // para o pc
        try {
            switch (spe.getEventType()) {
                case SerialPortEvent.DATA_AVAILABLE:
                    if (input == null) {
                        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
                    }
                    protocolo.setLeituraComando(input.readLine());
                    ;
                    //System.out.println("Chegou: " + protocolo.getLeituraComando());
                    telaUsuario.setTextJTextArea(protocolo.getLeituraComando() + "\n");
                    break;

                default:
                    break;
            }
        } catch (Exception e) {

        }
    }

    public Protocolo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }

    public String getSerialPortName() {
        return serialPortName;
    }

    public void setSerialPortName(String serialPortName) {
        this.serialPortName = serialPortName;
    }

    public static int getDataRate() {
        return DATA_RATE;
    }

}
