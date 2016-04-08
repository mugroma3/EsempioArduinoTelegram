import java.io.File;
import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Scanner;

import com.botticelli.bot.request.methods.UpdateRequest;
import com.botticelli.messagereceiver.MessageReceiver;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class Main {


	public static void main(String[] args) {



		SerialPort serialPort = InitializeArduino();
		
		if (serialPort == null)
			return;
		
		//serialPort.getOutputStream().write("R\n".getBytes());
		
		System.out.println("acceso arduino");
		
		UpdateRequest ur = new UpdateRequest();
		ur.setOffset(-1);
		File token = new File("token.txt");
		String tkn = "";
		try (Scanner s = new Scanner(token))
		{
			while (s.hasNext())
			{
				tkn = s.nextLine();
			}
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MessageReceiver mr = new MessageReceiver(new RGBMugBot(tkn, serialPort), 200, 1,ur);
		mr.start();
	}
	
	
	public static SerialPort InitializeArduino()
	{
		System.out.println("Program Started!!!");

		CommPortIdentifier serialPortId = null;

		Enumeration enumComm;

		enumComm = CommPortIdentifier.getPortIdentifiers();
		String portCom = null;
		while (enumComm.hasMoreElements()) {
			serialPortId = (CommPortIdentifier) enumComm.nextElement();
			if (serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL)
				portCom = serialPortId.getName();
		}

		if (portCom == null) {
			System.out.println("Non ho trovato alcun arduino attaccato");
			return null;
		}

		System.out.println(portCom);

		SerialPort serialPort = null;
		
		try {
			serialPort = (SerialPort) serialPortId.open("test", 5000);
			serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			Thread.sleep(2000);
		} catch (UnsupportedCommOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortInUseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		return serialPort;
	}
}
