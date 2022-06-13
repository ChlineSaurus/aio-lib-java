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
package com.adobe.aio.ims.feign;

import com.adobe.aio.ims.ImsService;
import com.adobe.aio.ims.model.AccessToken;
import com.adobe.aio.ims.util.PrivateKeyBuilder;
import com.adobe.aio.ims.util.TestUtil;
import com.adobe.aio.workspace.Workspace;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeignImsServiceIntegrationTest {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Test
  public void getAndValidateJwtExchangeAccessToken() {
    logger.warn("param1 system property: ", System.getProperty("param1"));
    logger.warn("param2 system property: ", System.getProperty("param2"));
    logger.warn("param1 system property present: ", !StringUtils.isBlank(System.getProperty("param1")));
    logger.warn("param2 system property present: ", !StringUtils.isBlank(System.getProperty("param2")));
    logger.warn("param1 env property: ", System.getenv("param1"));
    logger.warn("param2 env property: ", System.getenv("param2"));
    logger.warn("param1 env property present: ",  !StringUtils.isBlank(System.getenv("param1")));
    logger.warn("param2 env property present: ", !StringUtils.isBlank(System.getenv("param2")));


    Workspace workspace = TestUtil.getDefaultTestWorkspace();
    ImsService imsService = ImsService.builder().workspace(workspace).build();
    AccessToken accessToken = imsService.getJwtExchangeAccessToken();
    logger.info("JWT Exchange token flow complete");
    Assert.assertNotNull(accessToken);
    Assert.assertNotNull(accessToken.getAccessToken());
    Assert.assertTrue(imsService.validateAccessToken(accessToken.getAccessToken()));
    logger.info("JWT Exchange access token validated");
  }

}
