package com.currencyfair.mtp.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateToEpochValueDeserializer extends JsonDeserializer<Long> {
	@Override
	public Long deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
			throws IOException, JsonProcessingException {

		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
		String date = jsonparser.getText();
		try {
			return format.parse(date).getTime();
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}