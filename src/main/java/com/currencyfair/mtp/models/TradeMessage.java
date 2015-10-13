package com.currencyfair.mtp.models;

import java.io.Serializable;

import com.currencyfair.mtp.utils.DateToEpochValueDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class TradeMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userId;
	private String currencyFrom;
	private String currencyTo;
	private float amountSell;
	private float amountBuy;
	private float rate;
	@JsonDeserialize(using = DateToEpochValueDeserializer.class)
	private long timePlaced;
	private String originatingCountry;

	public TradeMessage() {
	}

	public String getUserId() {
		return userId;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public float getAmountSell() {
		return amountSell;
	}

	public float getAmountBuy() {
		return amountBuy;
	}

	public float getRate() {
		return rate;
	}

	public long getTimePlaced() {
		return timePlaced;
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}

	public String getCurrencyPair() {
		return currencyFrom + "/" + currencyTo;
	}

	public float getVolume() {
		return amountSell + amountBuy;
	}

	@Override
	public String toString() {
		return "TradeMessage [userId=" + userId + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo
				+ ", amountSell=" + amountSell + ", amountBuy=" + amountBuy + ", rate=" + rate + ", timePlaced="
				+ timePlaced + ", originatingCountry=" + originatingCountry + "]";
	}
}
