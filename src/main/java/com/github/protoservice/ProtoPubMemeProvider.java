package com.github.protoservice;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Message;

//IMPORTANT
//Copy paste this class to use protobug for jax rs
//Here we use jax-rs to use application/x-protobuf
//This is the provider class which has message body reader and writer method 
@Provider
@Consumes("application/x-protobuf")
@Produces("application/x-protobuf")
public class ProtoPubMemeProvider implements MessageBodyReader<Message>, MessageBodyWriter<Message> {

	public long getSize(Message message, Class<?> type, Type genericType, Annotation[] annotations, 
			MediaType mediaType) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			message.writeTo(baos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return baos.size();
	}
	
	
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return Message.class.isAssignableFrom(type);
	}

	public void writeTo(Message t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		t.writeTo(baos);
		entityStream.write(baos.toByteArray());
	}

	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return Message.class.isAssignableFrom(type);
	}

	public Message readFrom(Class<Message> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {
		try {
			Method builderMethod = type.getMethod("newBuilder");
			GeneratedMessage.Builder<?> builder = (GeneratedMessage.Builder<?>) builderMethod.invoke(type);
			return  builder.mergeFrom(entityStream).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
