package com.currencyfair.mtp;

import java.util.concurrent.ConcurrentHashMap;

import com.currencyfair.mtp.models.TradeMessage;

public class TradeMessagesContainer {
	private final static TradeMessagesContainer INSTANCE = new TradeMessagesContainer();
	private final static ConcurrentHashMap<String, Float> marketCurrencyVolume = new ConcurrentHashMap<String, Float>();

	private TradeMessagesContainer() {
	}

	public static TradeMessagesContainer getInstance() {
		return INSTANCE;
	}

	public ConcurrentHashMap<String, Float> getMarketCurrencyVolume() {
		return marketCurrencyVolume;
	}

	public synchronized void updateMarketCurrencyVolume(TradeMessage tradeMessage) {
		Float volume = marketCurrencyVolume.get(tradeMessage.getCurrencyPair());
		if (volume == null) {
			marketCurrencyVolume.put(tradeMessage.getCurrencyPair(), tradeMessage.getVolume());
		} else {
			marketCurrencyVolume.put(tradeMessage.getCurrencyPair(), volume + tradeMessage.getVolume());
		}
	}
}
