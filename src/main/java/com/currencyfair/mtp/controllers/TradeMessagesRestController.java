package com.currencyfair.mtp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.currencyfair.mtp.models.SimpleRestResponse;

@Controller
@RequestMapping("/api/trade-messages")
public class TradeMessagesRestController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody SimpleRestResponse createTradeMessage() {
		return SimpleRestResponse.getSimpleSuccessResponse("TradeMessage created.");
	}
}
