/*
 * Copyright (c) 2019, Okta, Inc. and/or its affiliates. All rights reserved.
 * The Okta software accompanied by this notice is provided pursuant to the Apache License,
 * Version 2.0 (the "License.")
 *
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.okta.oidc.results;

import com.okta.oidc.util.AuthorizationException;

public class Result {

    private final AuthorizationException error;
    protected boolean isCancel;

    Result(AuthorizationException error, boolean isCancel) {
        this.error = error;
        this.isCancel = isCancel;
    }

    public static Result success() {
        return new Result(null, false);
    }

    public static Result cancel() {
        return new Result(null, true);
    }

    public static Result error(AuthorizationException error) {
        return new Result(error, false);
    }

    public boolean isSuccess() {
        return getError() == null && !isCancel;
    }

    public boolean isCancel() {
        return isCancel;
    }

    public AuthorizationException getError() {
        return error;
    }

}