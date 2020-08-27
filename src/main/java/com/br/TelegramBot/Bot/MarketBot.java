package com.br.TelegramBot.Bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MarketBot extends TelegramLongPollingBot{

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		System.out.println(update.getMessage().getText());
		System.out.println(update.getMessage().getFrom().getFirstName());
		
		String command = update.getMessage().getText();
		
		SendMessage message = new SendMessage();
		
		if(command.equals("/myname")) {
			message.setText(update.getMessage().getFrom().getFirstName());
		}
		if(command.equals("/mylastname")) {
			message.setText(update.getMessage().getFrom().getLastName());
		}
		if(command.equals("/myfullname")) {
			message.setText(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
		}
		
		message.setChatId(update.getMessage().getChatId());
		
		try {
			execute(message);
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "";
	}
	
}
