/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package io.gs2.lock.control;

import org.json.JSONObject;
import java.util.List;
import io.gs2.lock.Gs2Lock;
import io.gs2.control.Gs2BasicRequest;

/**
 * @author Game Server Services, Inc.
 */
@SuppressWarnings("serial")
public class UnlockForceByUserRequest extends Gs2BasicRequest<UnlockForceByUserRequest> {

	public static class Constant extends Gs2Lock.Constant {
		public static final String FUNCTION = "UnlockForceByUser";
	}

	/** ロックプールの名前を指定します。 */
	private String lockPoolName;

	/** ユーザID */
	private String userId;

	/** ロック解除するリソースの名前 */
	private String resourceName;


	/**
	 * ロックプールの名前を指定します。を取得
	 *
	 * @return ロックプールの名前を指定します。
	 */
	public String getLockPoolName() {
		return lockPoolName;
	}

	/**
	 * ロックプールの名前を指定します。を設定
	 *
	 * @param lockPoolName ロックプールの名前を指定します。
	 */
	public void setLockPoolName(String lockPoolName) {
		this.lockPoolName = lockPoolName;
	}

	/**
	 * ロックプールの名前を指定します。を設定
	 *
	 * @param lockPoolName ロックプールの名前を指定します。
	 * @return this
	 */
	public UnlockForceByUserRequest withLockPoolName(String lockPoolName) {
		setLockPoolName(lockPoolName);
		return this;
	}

	/**
	 * ユーザIDを取得
	 *
	 * @return ユーザID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザIDを設定
	 *
	 * @param userId ユーザID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * ユーザIDを設定
	 *
	 * @param userId ユーザID
	 * @return this
	 */
	public UnlockForceByUserRequest withUserId(String userId) {
		setUserId(userId);
		return this;
	}

	/**
	 * ロック解除するリソースの名前を取得
	 *
	 * @return ロック解除するリソースの名前
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * ロック解除するリソースの名前を設定
	 *
	 * @param resourceName ロック解除するリソースの名前
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	/**
	 * ロック解除するリソースの名前を設定
	 *
	 * @param resourceName ロック解除するリソースの名前
	 * @return this
	 */
	public UnlockForceByUserRequest withResourceName(String resourceName) {
		setResourceName(resourceName);
		return this;
	}

}