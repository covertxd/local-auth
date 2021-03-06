/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Tyler Bucher
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.reallifegames.localauth.api.v1.login;

import io.jsonwebtoken.Jws;
import net.reallifegames.localauth.api.v1.ApiResponse;

import javax.annotation.Nonnull;

/**
 * A standard login api login response structure.
 *
 * @author Tyler Bucher
 */
class LoginResponse extends ApiResponse {

    /**
     * The return status message.
     */
    public final String message;

    /**
     * The users api {@link Jws} token.
     */
    public final String token;

    /**
     * Response constructor for Jackson json marshalling.
     *
     * @param apiResponse the root api response.
     * @param message     status message of this response.
     * @param token       the users api {@link Jws} token for login in.
     */
    public LoginResponse(@Nonnull final ApiResponse apiResponse,
                         @Nonnull final String message,
                         @Nonnull final String token) {
        super(apiResponse.version);
        this.message = message;
        this.token = token;
    }
}
