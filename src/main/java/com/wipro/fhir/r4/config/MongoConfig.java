/*
* AMRIT – Accessible Medical Records via Integrated Technology 
* Integrated EHR (Electronic Health Records) Solution 
*
* Copyright (C) "Piramal Swasthya Management and Research Institute" 
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.wipro.fhir.r4.config;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClientURI;
import com.wipro.fhir.r4.utils.CryptoUtil;
import com.wipro.fhir.r4.utils.config.ConfigProperties;

@Configuration
public class MongoConfig {

	@Autowired
	private CryptoUtil cryptoUtil;

	String uri = "mongodb://userName:pass@host:port/database?authSource=authentication";

	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException {
		String host = ConfigProperties.getPropertyByName("mongodb.host");
		String port = ConfigProperties.getPropertyByName("mongodb.port");
		String auth = ConfigProperties.getPropertyByName("mongodb.authentication-database");
		String database = ConfigProperties.getPropertyByName("mongodb.database");

		String userName = cryptoUtil.decrypt(ConfigProperties.getPropertyByName("encMongoDbUserName"));
		String pass = cryptoUtil.decrypt(ConfigProperties.getPropertyByName("encMongoDbPass"));
		String mongoURI = uri.replace("userName", userName).replace("pass", pass).replace("host", host)
				.replace("port", port).replace("database", database).replace("authentication", auth);

		return new SimpleMongoDbFactory(new MongoClientURI(mongoURI));
	}

	@Bean
	public MongoTemplate mongoTemplate() throws UnknownHostException {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

	}

}
