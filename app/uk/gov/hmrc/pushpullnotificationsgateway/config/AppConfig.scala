/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.pushpullnotificationsgateway.config

import javax.inject.{Inject, Singleton}
import play.api.Configuration
import uk.gov.hmrc.play.bootstrap.config.ServicesConfig

import scala.collection.JavaConverters._

@Singleton
class AppConfig @Inject()(config: Configuration, servicesConfig: ServicesConfig) {

  val authBaseUrl: String = servicesConfig.baseUrl("auth")

  val auditingEnabled: Boolean = config.get[Boolean]("auditing.enabled")
  val graphiteHost: String     = config.get[String]("microservice.metrics.graphite.host")

  val allowedUserAgentList: List[String] = config.underlying.getStringList("whitelisted.useragents").asScala.toList
  val allowedHostList: List[String] = config.underlying.getStringList("allowedHostList").asScala.toList

  val useProxy: Boolean = config.getOptional[Boolean]("proxy.proxyRequiredForThisEnvironment").getOrElse(false)
  val validateHttpsCallbackUrl: Boolean = config.getOptional[Boolean]("validateHttpsCallbackUrl").getOrElse(true)
  val authorizationToken: String = config.get[String]("authorizationKey")

}
