package com.zhangxin.mybatis.util;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonLibUtils {

	private static ObjectMapper mapper = new ObjectMapper();  
	  
    public static String bean2Json(Object obj) {  
        try {
			StringWriter sw = new StringWriter();  
			JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);  
			mapper.writeValue(gen, obj);  
			gen.close();  
			return sw.toString();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return null;
    }  
  
    public static <T> T json2Bean(String jsonStr, Class<T> objClass)  
            throws JsonParseException, JsonMappingException, IOException {  
        return mapper.readValue(jsonStr, objClass);  
    }  

}
