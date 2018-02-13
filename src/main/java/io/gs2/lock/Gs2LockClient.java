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

package io.gs2.lock;

import java.util.ArrayList;
import java.util.List;

import io.gs2.util.EncodingUtil;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.gs2.AbstractGs2Client;
import io.gs2.Gs2Constant;
import io.gs2.model.IGs2Credential;
import io.gs2.lock.control.*;

/**
 * GS2 Lock API クライアント
 *
 * @author Game Server Services, Inc.
 *
 */
public class Gs2LockClient extends AbstractGs2Client<Gs2LockClient> {

	public static String ENDPOINT = "lock";

	/**
	 * コンストラクタ。
	 *
	 * @param credential 認証情報
	 */
	public Gs2LockClient(IGs2Credential credential) {
		super(credential);
	}


	/**
	 * ロックプールを新規作成します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public CreateLockPoolResult createLockPool(CreateLockPoolRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode()
				.put("name", request.getName());

        if(request.getDescription() != null) body.put("description", request.getDescription());
        if(request.getServiceClass() != null) body.put("serviceClass", request.getServiceClass());
		HttpPost post = createHttpPost(
				Gs2Constant.ENDPOINT_HOST + "/lockPool",
				credential,
				ENDPOINT,
				CreateLockPoolRequest.Constant.MODULE,
				CreateLockPoolRequest.Constant.FUNCTION,
				body.toString());


		return doRequest(post, CreateLockPoolResult.class);

	}


	/**
	 * ロックプールを削除します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 */

	public void deleteLockPool(DeleteLockPoolRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/lockPool/" + (request.getLockPoolName() == null || request.getLockPoolName().equals("") ? "null" : request.getLockPoolName()) + "";



		HttpDelete delete = createHttpDelete(
				url,
				credential,
				ENDPOINT,
				DeleteLockPoolRequest.Constant.MODULE,
				DeleteLockPoolRequest.Constant.FUNCTION);


		doRequest(delete, null);

	}


	/**
	 * ロックプールの一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public DescribeLockPoolResult describeLockPool(DescribeLockPoolRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/lockPool";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getPageToken() != null) queryString.add(new BasicNameValuePair("pageToken", String.valueOf(request.getPageToken())));
        if(request.getLimit() != null) queryString.add(new BasicNameValuePair("limit", String.valueOf(request.getLimit())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeLockPoolRequest.Constant.MODULE,
				DescribeLockPoolRequest.Constant.FUNCTION);


		return doRequest(get, DescribeLockPoolResult.class);

	}


	/**
	 * サービスクラスの一覧を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public DescribeServiceClassResult describeServiceClass(DescribeServiceClassRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/lockPool/serviceClass";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				DescribeServiceClassRequest.Constant.MODULE,
				DescribeServiceClassRequest.Constant.FUNCTION);


		return doRequest(get, DescribeServiceClassResult.class);

	}


	/**
	 * ロックプールを取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public GetLockPoolResult getLockPool(GetLockPoolRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/lockPool/" + (request.getLockPoolName() == null || request.getLockPoolName().equals("") ? "null" : request.getLockPoolName()) + "";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetLockPoolRequest.Constant.MODULE,
				GetLockPoolRequest.Constant.FUNCTION);


		return doRequest(get, GetLockPoolResult.class);

	}


	/**
	 * ロックプールの状態を取得します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public GetLockPoolStatusResult getLockPoolStatus(GetLockPoolStatusRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/lockPool/" + (request.getLockPoolName() == null || request.getLockPoolName().equals("") ? "null" : request.getLockPoolName()) + "/status";



		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				GetLockPoolStatusRequest.Constant.MODULE,
				GetLockPoolStatusRequest.Constant.FUNCTION);


		return doRequest(get, GetLockPoolStatusResult.class);

	}


	/**
	 * ロックを取得します。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public LockResult lock(LockRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/lockPool/" + (request.getLockPoolName() == null || request.getLockPoolName().equals("") ? "null" : request.getLockPoolName()) + "/lock/transaction/" + (request.getTransactionId() == null || request.getTransactionId().equals("") ? "null" : request.getTransactionId()) + "/resource/" + (request.getResourceName() == null || request.getResourceName().equals("") ? "null" : request.getResourceName()) + "";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getTtl() != null) queryString.add(new BasicNameValuePair("ttl", String.valueOf(request.getTtl())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				LockRequest.Constant.MODULE,
				LockRequest.Constant.FUNCTION);

        get.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());

		return doRequest(get, LockResult.class);

	}


	/**
	 * ロックを取得します。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public LockByUserResult lockByUser(LockByUserRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/lockPool/" + (request.getLockPoolName() == null || request.getLockPoolName().equals("") ? "null" : request.getLockPoolName()) + "/lock/user/" + (request.getUserId() == null || request.getUserId().equals("") ? "null" : request.getUserId()) + "/transaction/" + (request.getTransactionId() == null || request.getTransactionId().equals("") ? "null" : request.getTransactionId()) + "/resource/" + (request.getResourceName() == null || request.getResourceName().equals("") ? "null" : request.getResourceName()) + "";

        List<NameValuePair> queryString = new ArrayList<>();
        if(request.getTtl() != null) queryString.add(new BasicNameValuePair("ttl", String.valueOf(request.getTtl())));


		if(queryString.size() > 0) {
			url += "?" + URLEncodedUtils.format(queryString, "UTF-8");
		}
		HttpGet get = createHttpGet(
				url,
				credential,
				ENDPOINT,
				LockByUserRequest.Constant.MODULE,
				LockByUserRequest.Constant.FUNCTION);


		return doRequest(get, LockByUserResult.class);

	}


	/**
	 * アンロックします。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 */

	public void unlock(UnlockRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/lockPool/" + (request.getLockPoolName() == null || request.getLockPoolName().equals("") ? "null" : request.getLockPoolName()) + "/lock/transaction/" + (request.getTransactionId() == null || request.getTransactionId().equals("") ? "null" : request.getTransactionId()) + "/resource/" + (request.getResourceName() == null || request.getResourceName().equals("") ? "null" : request.getResourceName()) + "";



		HttpDelete delete = createHttpDelete(
				url,
				credential,
				ENDPOINT,
				UnlockRequest.Constant.MODULE,
				UnlockRequest.Constant.FUNCTION);

        delete.setHeader("X-GS2-ACCESS-TOKEN", request.getAccessToken());

		doRequest(delete, null);

	}


	/**
	 * アンロックします。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 */

	public void unlockByUser(UnlockByUserRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/lockPool/" + (request.getLockPoolName() == null || request.getLockPoolName().equals("") ? "null" : request.getLockPoolName()) + "/lock/user/" + (request.getUserId() == null || request.getUserId().equals("") ? "null" : request.getUserId()) + "/transaction/" + (request.getTransactionId() == null || request.getTransactionId().equals("") ? "null" : request.getTransactionId()) + "/resource/" + (request.getResourceName() == null || request.getResourceName().equals("") ? "null" : request.getResourceName()) + "";



		HttpDelete delete = createHttpDelete(
				url,
				credential,
				ENDPOINT,
				UnlockByUserRequest.Constant.MODULE,
				UnlockByUserRequest.Constant.FUNCTION);


		doRequest(delete, null);

	}


	/**
	 * 強制的にアンロックします。<br>
	 * <br>
	 * このAPIを利用すると、トランザクションやロックカウンターの状態を無視して強制的にアンロック出来ます。<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 */

	public void unlockForceByUser(UnlockForceByUserRequest request) {

	    String url = Gs2Constant.ENDPOINT_HOST + "/lockPool/" + (request.getLockPoolName() == null || request.getLockPoolName().equals("") ? "null" : request.getLockPoolName()) + "/lock/user/" + (request.getUserId() == null || request.getUserId().equals("") ? "null" : request.getUserId()) + "/resource/" + (request.getResourceName() == null || request.getResourceName().equals("") ? "null" : request.getResourceName()) + "";



		HttpDelete delete = createHttpDelete(
				url,
				credential,
				ENDPOINT,
				UnlockForceByUserRequest.Constant.MODULE,
				UnlockForceByUserRequest.Constant.FUNCTION);


		doRequest(delete, null);

	}


	/**
	 * ロックプールを更新します<br>
	 * <br>
	 *
	 * @param request リクエストパラメータ

	 * @return 結果

	 */

	public UpdateLockPoolResult updateLockPool(UpdateLockPoolRequest request) {

		ObjectNode body = JsonNodeFactory.instance.objectNode();

        if(request.getDescription() != null) body.put("description", request.getDescription());
        if(request.getServiceClass() != null) body.put("serviceClass", request.getServiceClass());
		HttpPut put = createHttpPut(
				Gs2Constant.ENDPOINT_HOST + "/lockPool/" + (request.getLockPoolName() == null || request.getLockPoolName().equals("") ? "null" : request.getLockPoolName()) + "",
				credential,
				ENDPOINT,
				UpdateLockPoolRequest.Constant.MODULE,
				UpdateLockPoolRequest.Constant.FUNCTION,
				body.toString());


		return doRequest(put, UpdateLockPoolResult.class);

	}


}