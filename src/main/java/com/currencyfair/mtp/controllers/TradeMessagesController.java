package com.currencyfair.mtp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.currencyfair.mtp.models.RestResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Controller
@RequestMapping("/trade-messages")
@JsonInclude(Include.NON_NULL)
public class TradeMessagesController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody RestResponse<Object> getShopInJSON() {
		return RestResponse.getSuccessResponse("TradeMessage created.");
	}
}
