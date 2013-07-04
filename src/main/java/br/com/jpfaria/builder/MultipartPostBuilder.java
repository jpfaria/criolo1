package br.com.jpfaria.builder;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MultipartPostBuilder {

	private Logger logger = Logger.getLogger(MultipartPostBuilder.class);
	
	MultipartEntity reqEntity;

	MultipartPostBuilder() {
		reqEntity = new MultipartEntity();
	}

	public MultipartPostBuilder addPart(String name, ContentBody contentBody) {
		reqEntity.addPart(name, contentBody);
		return this;
	}

	public void build() throws IOException {

		HttpClient httpclient = new DefaultHttpClient();

		try {

			HttpPost httppost = new HttpPost("http://localhost:8080"
					+ "/servlets-examples/servlet/RequestInfoExample");

			httppost.setEntity(reqEntity);

			logger.info("executing request: " + httppost.getRequestLine());
			
			HttpResponse response = httpclient.execute(httppost);
			HttpEntity resEntity = response.getEntity();

			logger.info("status line: " + response.getStatusLine());
			
			if (resEntity != null) {
				
				logger.info("Response content length: "
						+ resEntity.getContentLength());
			}

			EntityUtils.consume(resEntity);

		} finally {

			httpclient.getConnectionManager().shutdown();
			
		}

	}

}
