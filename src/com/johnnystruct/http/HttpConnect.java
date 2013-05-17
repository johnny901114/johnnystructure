package com.johnnystruct.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

import org.apache.http.conn.ConnectTimeoutException;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.johnnystruct.R;
import com.johnnystruct.bean.RequestStatus;

/**
 * Http连接
 */
public class HttpConnect {
	public static final int IO_BUFFER_SIZE = 8 * 1024;
	public static final String TAG = HttpConnect.class.getSimpleName();// "HttpConnect";
	private static final int defaultConnectTimeout = 10000;
	public static final int GET = 0;
	public static final int POST = 1;
	/**
	 * Simple network connection check.
	 * 
	 * @param context
	 * @return boolean isConnect
	 */
	public static boolean checkConnection(Context context) {
		final ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		final NetworkInfo networkInfo = cm.getActiveNetworkInfo();
		if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
			Toast.makeText(context, R.string.no_network_connection_toast,
					Toast.LENGTH_LONG).show();
			Log.e(TAG, "checkConnection - no connection found");
			return false;
		}

		return true;
	}

	/**
	 * Download a bitmap from a URL and write the content to an output stream.
	 * 
	 * @param urlString
	 *            The URL to fetch
	 * @return true if successful, false otherwise
	 */
	private int downloadUrlToStream(String urlString, boolean isPost,
			OutputStream outputStream, int connectTimeout, String parameters) {
		disableConnectionReuseIfNecessary();
		HttpURLConnection urlConnection = null;
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		OutputStream os = null;
		try {
			final URL url = new URL(urlString);
			urlConnection = (HttpURLConnection) url.openConnection();
			if (isPost) {
				urlConnection.setDoOutput(true);
				urlConnection.setDoInput(true);
				urlConnection.setRequestMethod("POST");
				if (!TextUtils.isEmpty(parameters)) {
					os = urlConnection.getOutputStream();
					os.write(parameters.getBytes());
					os.flush();
				}
			} else {
				urlConnection.setDoOutput(false);
				urlConnection.setDoInput(true);
				urlConnection.setRequestMethod("GET");
			}
			urlConnection.setConnectTimeout(connectTimeout);
			if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
				return RequestStatus.CODE_TASK_RESULT_FAILURE;
			}

			in = new BufferedInputStream(urlConnection.getInputStream(),
					IO_BUFFER_SIZE);
			out = new BufferedOutputStream(outputStream, IO_BUFFER_SIZE);

			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			return RequestStatus.CODE_TASK_RESULT_SUCCESS;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return RequestStatus.CODE_TASK_RESULT_INVALID_URL;
		} catch (IOException e) {
			e.printStackTrace();
			if (e instanceof ConnectTimeoutException) {
				return RequestStatus.CODE_TASK_RESULT_CONNECT_TIMEOUT;
			} else if (e instanceof SocketTimeoutException) {
				return RequestStatus.CODE_TASK_RESULT_SOCKET_TIMEOUT;
			} else {
				return RequestStatus.CODE_TASK_RESULT_FAILURE;
			}
		} finally {
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
			try {
				if (os != null) {
					os.close();
				}
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (final IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int sendGetRequest(String urlString, OutputStream outputStream) {
		return downloadUrlToStream(urlString, false, outputStream,
				defaultConnectTimeout, null);
	}

	public int sendGetRequest(String urlString, OutputStream outputStream,
			int timeout) {
		return downloadUrlToStream(urlString, false, outputStream, timeout,
				null);
	}

	public int sendPostRequest(String urlString, String parameters,
			OutputStream outputStream) {
		return downloadUrlToStream(urlString, true, outputStream,
				defaultConnectTimeout, parameters);
	}

	public int sendPostRequest(String urlString, String parameters,
			OutputStream outputStream, int timeout) {
		return downloadUrlToStream(urlString, true, outputStream, timeout,
				parameters);
	}

	/**
	 * Workaround for bug pre-Froyo, see here for more info:
	 * http://android-developers.blogspot.com/2011/09/androids-http-clients.html
	 */
	private static void disableConnectionReuseIfNecessary() {
		// HTTP connection reuse which was buggy pre-froyo
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.FROYO) {
			System.setProperty("http.keepAlive", "false");
		}
	}
}
