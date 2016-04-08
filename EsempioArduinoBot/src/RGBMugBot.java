import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.botticelli.bot.Bot;
import com.botticelli.bot.request.methods.MessageToSend;
import com.botticelli.bot.request.methods.types.ChosenInlineResult;
import com.botticelli.bot.request.methods.types.InlineQuery;
import com.botticelli.bot.request.methods.types.Message;
import com.botticelli.bot.request.methods.types.ReplyKeyboardMarkup;

import gnu.io.SerialPort;

public class RGBMugBot extends Bot{

	
	private ReplyKeyboardMarkup rkm;
	private SerialPort serialPort;
	
	
	public RGBMugBot(String token, SerialPort serialPort) {
		super(token);
		List<List<String>> keyboard = new ArrayList<List<String>>();
		List<String> line = new ArrayList<>();

		line.add("Red");
		line.add("Yellow");
		line.add("Green");
		
		keyboard.add(line);
		rkm = new ReplyKeyboardMarkup(keyboard);
		
		this.serialPort = serialPort;
	}

	@Override
	public void audioMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chose_inline_result(ChosenInlineResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contactMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void documentMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void groupChatCreatedMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void groupChatPhotoDeleteMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inLineQuery(InlineQuery arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftChatParticipantMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void locationMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newChatParticipantMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newChatPhotoMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newChatTitleMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void photoMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stickerMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void textMessage(Message arg0) {
		
		String text = arg0.getText();
		
		if (text.equals("/start"))
		{
			MessageToSend mts = new MessageToSend(arg0.getChat().getId(), "Your remote is ready");
			mts.setReplyMarkup(rkm);
			sendMessage(mts);
			return;
		}
		
		if(text.equals("Red"))
		{
			System.out.println("Rosso");
			try {
				serialPort.getOutputStream().write("R\n".getBytes());
				Thread.sleep(80);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
		if(text.equals("Green"))
		{
			System.out.println("Verde");
			try {
				serialPort.getOutputStream().write("G\n".getBytes());
				Thread.sleep(80);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(text.equals("Yellow"))
		{
			System.out.println("Giallo");
			try {
				serialPort.getOutputStream().write("Y\n".getBytes());
				Thread.sleep(80);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void videoMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voiceMessage(Message arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
