/*
 * Copyright 2017 Adobe. All rights reserved.
 * This file is licensed to you under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
 * OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.adobe.ims;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImsServiceTestDrive {

  private static Logger logger = LoggerFactory.getLogger(ImsServiceTestDrive.class);

  public static void main(String[] args) {
    try {
      JwtTokenBuilder jwtTokenBuilder =
          JwtTokenBuilder.build((args != null && args.length > 0) ? args[0] : null);
      logger.info("jwtToken: " + jwtTokenBuilder.getJwtToken());
      AccessToken accessToken = ImsService.build(jwtTokenBuilder).getJwtExchangeAccessToken();
      logger.info("accessToken: " + accessToken.getAccessToken());
      System.exit(0);
    } catch (Exception e) {
      logger.error(e.getMessage(),e);
      System.exit(-1);
    }
  }


}
