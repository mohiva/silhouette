/**
 * Licensed to the Minutemen Group under one or more contributor license
 * agreements. See the COPYRIGHT file distributed with this work for
 * additional information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package silhouette.crypto

import cats.effect.IO
import org.specs2.mutable.Specification

/**
 * Test case for the [[SecureRandomID]] class.
 */
class SecureRandomIDSpec extends Specification {

  "The generator" should {
    "return a 128 byte length secure random number" in {
      val id = new SecureRandomID[IO]().get.unsafeRunSync()

      id must have size (128 * 2)
      id must beMatching("[a-f0-9]+")
    }

    "return a 265 byte length secure random number" in {
      val id = new SecureRandomID[IO](256).get.unsafeRunSync()

      id must have size (256 * 2)
      id must beMatching("[a-f0-9]+")
    }
  }
}
