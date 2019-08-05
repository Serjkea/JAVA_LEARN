package ru.practics.jsonparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonParser {
	
	private static String jsonPath = "";
	
	public static void setJsonPath(String path) {
		jsonPath = path;
	}
	
	public static Object parseToObject() {
		if (jsonPath != null) {
			String str = fileToString(jsonPath);
			return strToMap(str);
		}
		return null;
	}
	
	public static Map<String, String> strToMap(String str) {
		if (str != null) {
			Map<String,String> map = new HashMap<String,String>();
			StringBuilder name = new StringBuilder();
			char[] charSeq = str.toCharArray();
			int sIndex = 0;
			int lIndex = 0;
			byte cnt = 0;
			boolean isFindName = false;
			for(int i=0;i<charSeq.length;i++) {
				if ((charSeq[i] == '"')&&(cnt==0)) {
					sIndex = i+1;
					cnt++;
				} else if ((charSeq[i] == '"')&&(cnt==1)&&((charSeq[i+2] != '{')&&(charSeq[i+2] != '['))) {
					if (isFindName) {
						lIndex = i;
						map.put(name.toString(), str.substring(sIndex,lIndex));
						isFindName = false;
						name.delete(0, name.length());
						cnt = 0;
					} else {
						lIndex = i;
						name.append(str.substring(sIndex, lIndex));
						isFindName = true;
						cnt = 0;
					}
				} else if ((charSeq[i] == '"')&&(cnt==1)&&((charSeq[i+2] == '{')||(charSeq[i+2] == '['))) {
					cnt = 0;
					sIndex = 0;
					lIndex = 0;
					name.delete(0, name.length());
					isFindName = false;
				}
			}
			return map;
		}
		return null;
	}
	
	private static String fileToString(String path) {
		try {
			StringBuilder sb = new StringBuilder();
			FileReader fis = new FileReader(new File(path));
			char[] cbuf;
			boolean isDeck = false;
			while(fis.ready()) {
				cbuf = Character.toChars(fis.read());
				if (cbuf[0] == '"') isDeck = !isDeck;
				if(((cbuf[0] == ' ')||(cbuf[0] == '\n'))&&!isDeck) {
					continue;
				} 
				sb.append(cbuf);
			}
			fis.close();
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		JsonParser.setJsonPath("/space/projects/Lab355/kostenko/Docs/Projects/example.json");
		Map<String,String> resultMap = (Map)JsonParser.parseToObject();
		System.out.println(resultMap.keySet());
		System.out.println(resultMap.get("pageName"));
		System.out.println(resultMap.get("pagePic"));
		System.out.println(resultMap.get("post_id"));
		System.out.println(resultMap.get("actor_id"));
	}

}
