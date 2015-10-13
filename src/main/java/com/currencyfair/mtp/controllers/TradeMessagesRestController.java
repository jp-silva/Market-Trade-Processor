package com.currencyfair.mtp.controllers;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.currencyfair.mtp.TradeMessagesContainer;
import com.currencyfair.mtp.models.RestResponse;
import com.currencyfair.mtp.models.SimpleRestResponse;
import com.currencyfair.mtp.models.TradeMessage;

@Controller
@RequestMapping("/api/trade-messages")
public class TradeMessagesRestController {
	private static final Logger LOG = LoggerFactory.getLogger(TradeMessagesRestController.class);

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody SimpleRestResponse createTradeMessage(@RequestBody TradeMessage tradeMessage) {
		TradeMessagesContainer.getInstance().updateMarketCurrencyVolume(tradeMessage);

		LOG.debug(tradeMessage.toString());

		return SimpleRestResponse.getSimpleSuccessResponse("TradeMessage created.");
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody RestResponse<ConcurrentHashMap<String, Float>> getTradeMessage() {
		ConcurrentHashMap<String, Float> messages = TradeMessagesContainer.getInstance().getMarketCurrencyVolume();
		return RestResponse.getSuccessResponse("TradeMessages.", messages);
	}
}
